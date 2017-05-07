package pt.meo.test.nowandnextsampleapp.activities;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import pt.meo.test.nowandnextsampleapp.R;
import pt.meo.test.nowandnextsampleapp.adapters.NowAndNextRecyclerViewAdapter;
import pt.meo.test.nowandnextsampleapp.network.MeoNowAndNextService;
import pt.meo.test.nowandnextsampleapp.network.ServiceGenerator;
import pt.meo.test.nowandnextsampleapp.network.response.models.ChannelInformation;
import pt.meo.test.nowandnextsampleapp.network.response.models.ChannelList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

/**
 * The Activity showing the channel list
 */
public class ChannelListActivity extends AppCompatActivity {
    @BindView(R.id.srl_swiperefresh)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.rv_channel_list)
    RecyclerView channelListRecyclerView;


    private LinearLayoutManager layoutManager;
    private NowAndNextRecyclerViewAdapter nowAndNextRecyclerViewAdapter;
    private String currentPageChannelList = "";
    private String nextPageChannelList = "";
    private MeoNowAndNextService meoNowAndNextService;

    private boolean isLoading = false; // true if the list is currently loading, false otherwise
    private Integer totalChannelCount;

    // load channels callback
    private Callback<ChannelList> getChannelsCallback = new Callback<ChannelList>() {
        @Override
        public void onResponse(Call<ChannelList> call, Response<ChannelList> response) {
            isLoading = false;
            if (swipeRefreshLayout.isRefreshing()) {
                swipeRefreshLayout.setRefreshing(false);
            }
            if (!response.isSuccessful()) {
                Timber.e(response.errorBody().toString());
                return;
            }
            ChannelList channelList = response.body();
            if (channelList != null) {
                totalChannelCount = channelList.getOdataCount();
                List<ChannelInformation> channelInformationList = channelList.getChannelInformation();
                if (channelInformationList != null && channelInformationList.size() > 0) {
                    nowAndNextRecyclerViewAdapter.addAll(channelInformationList);
                    Timber.d("Current channel Page %s", currentPageChannelList);

                    Timber.d("Next channel Page %s", channelList.getNextChannelPage());
                    currentPageChannelList = nextPageChannelList;
                    nextPageChannelList = channelList.getNextChannelPage();
                }
            }

        }

        @Override
        public void onFailure(Call<ChannelList> call, Throwable t) {
            // todo: show error messages
        }
    };
    // callback to load more channels on scroll
    private RecyclerView.OnScrollListener recyclerViewOnScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            int visibleItemCount = layoutManager.getChildCount();
            int totalItemCount = layoutManager.getItemCount();
            int firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();
            // loads if is not loading and if we reached the bottom of the current list
            if (!isLoading && nextPageChannelList != null && !nextPageChannelList.isEmpty()
                    && (visibleItemCount + firstVisibleItemPosition) >= totalItemCount
                    && dy > 0
                    && totalChannelCount > totalItemCount) {

                loadMoreChannels();
            }

        }
    };
    // callback to implement refresh on swipe
    private SwipeRefreshLayout.OnRefreshListener onRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            nowAndNextRecyclerViewAdapter.clearList();
            firstLoadChannels();
        }
    };

    private void firstLoadChannels() {
        Call<ChannelList> channelList = meoNowAndNextService.getChannelList();
        channelList.enqueue(getChannelsCallback);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_channel_list);
        ButterKnife.bind(this);
        initServices();

    }

    @Override
    protected void onStart() {
        super.onStart();
        nowAndNextRecyclerViewAdapter = new NowAndNextRecyclerViewAdapter();
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        channelListRecyclerView.setLayoutManager(layoutManager);
        channelListRecyclerView.setAdapter(nowAndNextRecyclerViewAdapter);
        channelListRecyclerView.addOnScrollListener(recyclerViewOnScrollListener);
        swipeRefreshLayout.setOnRefreshListener(onRefreshListener);
        firstLoadChannels();
    }

    /**
     * Initializes the retrofit service that fetches the channels
     */
    private void initServices() {
        meoNowAndNextService = ServiceGenerator
                .createService(MeoNowAndNextService.class, MeoNowAndNextService.BASE_URL);
    }

    /**
     * Loads more channels while there is channels to load
     */
    private void loadMoreChannels() {
        if (nextPageChannelList != null && !nextPageChannelList.isEmpty()
                && !nextPageChannelList.equalsIgnoreCase(currentPageChannelList)) {
            isLoading = true;
            Call<ChannelList> channelListCall = meoNowAndNextService.getChannelListCall(nextPageChannelList);
            channelListCall.enqueue(getChannelsCallback);
        }

    }
}
