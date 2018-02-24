import java.util.*;

class Movie {
    int movieId;
    float rating;
    List<Movie> similarMovies;
    public Movie(int movieId, float rating) {
        this.movieId = movieId;
        this.rating = rating;
        this.similarMovies = new ArrayList<Movie>();
    }
}

public class MovieNetwork {

    public static void main(String[] args) {

    }

    public List<Movie> getNearest(Movie movie, int count) {
        List<Movie> movies = new ArrayList<>();
        if (count == 0) {
            return movies;
        }

        PriorityQueue<Movie> pq = new PriorityQueue<Movie>(count, new Comparator<Movie>(){
            @Override
            public int compare(Movie m1, Movie m2) {
                return (m1.rating - m2.rating > 0) ? 1 : -1;
            }
        });
        Queue<Movie> queue = new LinkedList<Movie>();
        Set<Movie> set = new HashSet<>();
        
        for (Movie tmp : movie.similarMovies) {
            if (!set.contains(tmp)) {
                queue.offer(tmp);
                set.add(tmp);
            }
        }

        while (!queue.isEmpty()) {
            Movie tmp = queue.poll();
            if (pq.size() < count) {
                pq.add(tmp);
            } else {
                if (pq.peek().rating < tmp.rating) {
                    pq.poll();
                    pq.add(tmp);
                }
            }
            for (Movie m : tmp.similarMovies) {
                if (!set.contains(m)) {
                    queue.offer(m);
                    set.add(m);
                }
            }
        }

        while (!pq.isEmpty()) {
            movies.add(pq.poll());
        }

        return movies;
    }
}