package anywhere.com.videoplayer;

public class VideoPlayerConfig {
    public static final int MIN_BUFFER_DURATION = 3000;
    //Max Video you want to buffer during PlayBack
    public static final int MAX_BUFFER_DURATION = 5000;
    //Min Video you want to buffer before start Playing it
    public static final int MIN_PLAYBACK_START_BUFFER = 1500;
    //Min video You want to buffer when user resumes video
    public static final int MIN_PLAYBACK_RESUME_BUFFER = 5000;

  //  public static final String DEFAULT_VIDEO_URL = "https://androidwave.com/media/androidwave-video-3.mp4";
    public static final String DEFAULT_VIDEO_URL = "http://techslides.com/demos/sample-videos/small.mp4";
  //  public static final String DEFAULT_VIDEO_URL = "http://download.blender.org/peach/bigbuckbunny_movies/BigBuckBunny_320x180.mp4";
}
