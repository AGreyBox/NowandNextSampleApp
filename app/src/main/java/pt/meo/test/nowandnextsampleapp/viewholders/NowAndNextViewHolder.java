package pt.meo.test.nowandnextsampleapp.viewholders;

import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import pt.meo.test.nowandnextsampleapp.R;
import pt.meo.test.nowandnextsampleapp.network.response.models.ChannelInformation;
import pt.meo.test.nowandnextsampleapp.network.response.models.ChannelProgramInformation;
import pt.meo.test.nowandnextsampleapp.network.response.models.NowAndNextLiveChannelProgram;
import timber.log.Timber;

/**
 * Channel View Holder
 * Created by dplopez on 07-05-2017.
 */

public class NowAndNextViewHolder extends ViewHolder implements View.OnClickListener {
    private final Context context;
    @BindView(R.id.iv_channel_preview)
    ImageView channelPreview;

    @BindView(R.id.tv_channel_current_program)
    TextView channelCurrentProgram;

    @BindView(R.id.tv_channel_next_program)
    TextView channelNextProgram;
    private ChannelInformation channelInformation;

    //Constructor, default
    public NowAndNextViewHolder(View itemView) {
        super(itemView);
        context = itemView.getContext();
        itemView.setOnClickListener(this);
        ButterKnife.bind(this, itemView);
    }
    public void clearHolder() {
        channelPreview.setImageResource(R.drawable.meo_logo);
        channelCurrentProgram.setText("");
        channelNextProgram.setText("");
        channelInformation = null;

    }
    /**
     * Sets the channel information that this view will be holding
     *
     * @param nowAndNextLiveChannelProgram the channel program
     */
    public void setNowAndNextProgram(NowAndNextLiveChannelProgram nowAndNextLiveChannelProgram) {
        ChannelProgramInformation nowProgram = null;
        if (nowAndNextLiveChannelProgram.getChannelProgramList().size() > 0) {
            nowProgram = nowAndNextLiveChannelProgram
                    .getChannelProgramList().get(0);
        }
        ChannelProgramInformation nextProgram = null;
        if (nowAndNextLiveChannelProgram.getChannelProgramList().size() > 1) {
            nextProgram = nowAndNextLiveChannelProgram
                    .getChannelProgramList().get(1);
        }
        String unknownTitle = context.getString(R.string.unknown_title);
        String nowTitle = nowProgram != null ? nowProgram.getTitle() : unknownTitle;
        String nextTitle = nextProgram != null ? nextProgram.getTitle() : "";

        String callLetter = nowProgram != null ? nowProgram.getCallLetter() : unknownTitle;
        String urlTemplate = context.getString(R.string.image_url_template,
                nowTitle,
                callLetter);
        Timber.d("Encoded image url [ %s } ", urlTemplate);
        Picasso.with(context).load(urlTemplate)
                .error(R.drawable.meo_logo)
                .placeholder(R.drawable.meo_logo)
                .into(channelPreview);
        channelCurrentProgram.setText(nowTitle);
        channelNextProgram.setText(nextTitle);
    }

    /**
     * Sets the current channel information
     * @param channelInformation the channel information for the current channel
     */
    public void setChannel(ChannelInformation channelInformation) {
        this.channelInformation = channelInformation;
    }

    @Override
    public void onClick(View v) {
        if (channelInformation != null) {
            Toast.makeText(itemView.getContext(),
                    String.format("Channel %s : %s\nDescription  : %s",
                            channelInformation.getCatalogOrderNumber(),
                            channelInformation.getTitle(),
                            channelInformation.getDescription()), Toast.LENGTH_LONG).show();
        }
    }
}
