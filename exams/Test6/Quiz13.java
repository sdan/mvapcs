public class Quiz13   {

	public static void main ( String [] args )   {
		Quiz13 recurseit = new Quiz13 ( );

		System.out.println ( "\n\n\n" );
		recurseit.mystery ( 1234 );
		System.out.println ( "\n\n\n" );
	}

	/** Precondition: x >= 0
	*/
	public void mystery ( int x )   {
		System.out.print ( x % 10 );
		
		if ( ( x / 10 ) != 0 )   {
			mystery ( x / 10 );
		}

		System.out.print ( x % 10 );
	}
}