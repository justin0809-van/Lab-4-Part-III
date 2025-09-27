Project: music-organizer-v3. A project to collect audio files.
Authors: David J. Barnes and Michael Kölling

This project is part of the material for the book

   Objects First with Java - A Practical Introduction using BlueJ
   Seventh edition
   David J. Barnes and Michael Kölling

It is discussed in chapter 4.

To start:

Create a MusicOrganizer object on the object bench.
Use its methods to add, remove, and play files. The listAllFiles
method prints a list of the collection.

PART 3

21)After creating a music organizer, i added files and it printed in the code pad.

24) public void listWithIndex(ArrayList<String> filesnames) {
        int position = 0;
        for (String filename : files) {
            System.out.println(position + ": "+ filename);
            position++;
        }
    }
and i also added
files.add("Burning man.mp3");
        files.add("Livid.mp3");
        files.add("Maverick.mp3");
    
        
26)  public void listMatching(String searchString) {
        boolean found = false;
        
        for(String filename: files) {
            if(filename.contains(searchString)) {
                // A match.
                System.out.println(filename);
                found = true;


27) I compiled my code in the Music organizer. One of my mom's friend tutored me during this.



28) for (Track track : trackList)