package chapter03;

public class SongApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Song song = new Song();
		
//		song.setTitle("좋은날");
//		song.setArtist("아이유");
//		song.setAlbum("이민수");
//		song.setComposer("Real");
//		song.setYear(210);
//		song.setTrack(3);
//		song.show();		
//		
		Song song1 = new Song("좋은날","아이유","이민수","Real",210,3);
		song1.show();
		//song song2 = new Song("","");
	}

}
