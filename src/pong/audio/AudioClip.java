package pong.audio;

/**
 *
 * @author d.peters
 */
public class AudioClip implements Comparable<AudioClip>{

    /**
     * 
     */
    private final String location;
    
    /**
     * 
     * @param location 
     */
    public AudioClip(String location){
        this.location = location;
    }
    
    /**
     * 
     * @return 
     */
    public String getLocation(){
        return this.location;
    }

    @Override
    public int compareTo(AudioClip o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
