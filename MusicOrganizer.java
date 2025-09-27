import java.util.ArrayList;

/**
 * A class to hold details of audio files.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 7.3
 */
public class MusicOrganizer
{
    // An ArrayList for storing the file names of music files.
    private ArrayList<String> files;
    // A player for the music files.
    private MusicPlayer player;
    
    private ArrayList<Track> tracks;
        
    /**
     * Create a MusicOrganizer
     */
    public MusicOrganizer()
    {
        files = new ArrayList<>();
        player = new MusicPlayer();
        tracks = new ArrayList<>();
        tracks.add(new Track("Burning man.mp3", "ArtistName"));
        tracks.add(new Track("Livid.mp3", "ArtistName"));
        tracks.add(new Track("Maverick.mp3", "OtherArtist"));
    }
    
    public class Track {
        private String filename;
        private String artist;
        
        public Track(String filename, String artist) {
            this.filename = filename;
            this.artist = artist;
        }
        
        public String getFilename() {
            return filename;
        }
        
        public String getArtist() {
            return artist;
        }
    }
    
    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     */
    public void addFile(String filename)
    {
        files.add(filename);
    }
    
    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles()
    {
        return files.size();
    }
    
    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    public void listFile(int index)
    {
        if(validIndex(index)) {
            String filename = files.get(index);
            System.out.println(filename);
        }
    }
    
    public void listWithIndex(ArrayList<String> filesnames) {
        int position = 0;
        for (String filename : files) {
            System.out.println(position + ": "+ filename);
            position++;
        }
    }
    
    public void listMatching(String searchString) {
        boolean found = false;
        
        for(String filename: files) {
            if(filename.contains(searchString)) {
                // A match.
                System.out.println(filename);
                found = true;
            }
        }
    }
    
    public void playArtistSamples(String artistName) {
        for (Track track : tracks) {
            if (track.getArtist().equalsIgnoreCase(artistName)) {
                player.playSample(track.getFilename());
            }
        }
    }

    
    /**
     * Show a list of all the files in the collection.
     */
    public void listAllFiles()
    {
        for(String filename : files) {
            System.out.println(filename);
        }
    }
    
    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index)
    {
        if(validIndex(index)) {
            files.remove(index);
        }
    }

    /**
     * Start playing a file in the collection.
     * Use stopPlaying() to stop it playing.
     * @param index The index of the file to be played.
     */
    public void startPlaying(int index)
    {
        if(validIndex(index)) {
            String filename = files.get(index);
            player.startPlaying(filename);
        }
    }

    /**
     * Stop the player.
     */
    public void stopPlaying()
    {
        player.stop();
    }

    /**
     * Play a file in the collection. Only return once playing has finished.
     * @param index The index of the file to be played.
     */
    public void playAndWait(int index)
    {
        if(validIndex(index)) {
            String filename = files.get(index);
            player.playSample(filename);
        }
    }

    /**
     * Determine whether the given index is valid for the collection.
     * Print an error message if it is not.
     * @param index The index to be checked.
     * @return true if the index is valid, false otherwise.
     */
    private boolean validIndex(int index)
    {
        // The return value.
        // Set according to whether the index is valid or not.
        boolean valid;
        
        if(index < 0) {
            System.out.println("Index cannot be negative: " + index);
            valid = false;
        }
        else if(index >= files.size()) {
            System.out.println("Index is too large: " + index);
            valid = false;
        }
        else {
            valid = true;
        }
        return valid;
    }
}
