import java.util.Scanner;

import com.moviecrud.dao.MovieDAO;
import com.moviecrud.model.Movie;
public class App {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);		
		MovieDAO movieDao = new MovieDAO();
		int input = 5;
		do {
			System.out.println("\nChoose any option");
			System.out.println("1. Add Movie\n2. Update Movie\n3. Delete Movie\n4. Get Movie Details\n0. Exit");
			input = sc.nextInt();
			switch (input) {
			case 0: // case 0 is for exit only
				break;
			case 1: System.out.println("Enter the movie details as \nMovieId,  Name,  Language, Released In, Revenue Dollers");
					String movieId=sc.next();
					String name=sc.next();
					String language = sc.next();
					int releasedIn = sc.nextInt();
					int revenueDollers = sc.nextInt();
					Movie movie = new Movie(movieId, name, language, releasedIn, revenueDollers);
					movieDao.addMovie(movie);				
				break;
			case 2: System.out.println("Enter the movie Id: ");
					String id = sc.next();
					movieDao.updateMovie(id);
				break;
			case 3: System.out.println("Enter the Movie Id: ");
					String mid = sc.next();
					movieDao.deleteMovie(mid);
				break;
			case 4: System.out.println("Enter the Movie Id: ");
					String mId = sc.next();
					Movie movieDetail = movieDao.getMovieDetails(mId);
					if(movieDetail==null)
						System.out.println("No records found for the id: "+mId);
					else
					System.out.println(movieDetail);
				break;
			default:
				System.out.println("Enter a valid number between 0 to 4");
				break;
			}
			
		} while (input!=0);
		
		MovieDAO.closeSessionFactory();
		sc.close();
		System.out.println("Thank you!!!");
	}
}