package pt.meo.test.nowandnextsampleapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import pt.meo.test.nowandnextsampleapp.R;
import pt.meo.test.nowandnextsampleapp.network.MeoNowAndNextService;
import pt.meo.test.nowandnextsampleapp.network.ServiceGenerator;
import pt.meo.test.nowandnextsampleapp.network.response.models.ChannelInformation;
import pt.meo.test.nowandnextsampleapp.network.response.models.NowAndNextLiveChannelProgram;
import pt.meo.test.nowandnextsampleapp.viewholders.NowAndNextViewHolder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

/**
 * Channel Information POJO
 * Created by dplopez on 07-05-2017.
 * Channel list adapter
 */

public class NowAndNextRecyclerViewAdapter extends RecyclerView.Adapter<NowAndNextViewHolder> {

    private final MeoNowAndNextService meoNowAndNextService;
    private List<ChannelInformation> channelList;

    public NowAndNextRecyclerViewAdapter() {
        channelList = new ArrayList<>();
        meoNowAndNextService = ServiceGenerator.createService(MeoNowAndNextService.class, MeoNowAndNextService.BASE_URL);
    }

    @Override
    public NowAndNextViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.channel_information_row, parent, false);
        return new NowAndNextViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final NowAndNextViewHolder holder, int position) {
        holder.clearHolder();
        Call<NowAndNextLiveChannelProgram> channelNowAndNext =
                meoNowAndNextService
                        .getChannelNowAndNext(String.format(MeoNowAndNextService.CALL_LETTER_EQ,
                        getItem(position).getCallLetter()));
        channelNowAndNext.enqueue(new Callback<NowAndNextLiveChannelProgram>() {
            @Override
            public void onResponse(Call<NowAndNextLiveChannelProgram> call, Response<NowAndNextLiveChannelProgram> response) {
                if (response.isSuccessful()) {
                    NowAndNextLiveChannelProgram body = response.body();
                    holder.setNowAndNextProgram(body);
                }
            }

            @Override
            public void onFailure(Call<NowAndNextLiveChannelProgram> call, Throwable t) {

            }
        });
    }

    public void addAll(List<ChannelInformation> channelInformationList) {
        for (ChannelInformation channelInformation : channelInformationList) {
            add(channelInformation);
        }

        Timber.d("New size : %d", getItemCount());
    }

    // region Helper Methods
    public ChannelInformation getItem(int position) {
        return channelList.get(position);
    }

    public void add(ChannelInformation channelInformation) {
        channelList.add(channelInformation);
        notifyItemChanged(channelList.size() - 1);
    }

    public void remove(ChannelInformation channelInformation) {
        int position = channelList.indexOf(channelInformation);
        if (position != -1) {
            channelList.remove(position);
            notifyDataSetChanged();
        }
    }

    public void clearList() {
        while (getItemCount() > 0) {
            remove(getItem(0));
        }
    }

    @Override
    public int getItemCount() {
        return channelList.size();
    }
}
