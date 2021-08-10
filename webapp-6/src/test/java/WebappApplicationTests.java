import com.springproject.webapp.converter.MovieConverter;
import com.springproject.webapp.dao.MovieJpaRepository;
import com.springproject.webapp.entity.Movie;
import com.springproject.webapp.service.MovieService;
import com.springproject.webapp.service.MovieServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={com.springproject.webapp.WebappApplication.class})
class WebappApplicationTests {

	@Test
	void contextLoads() {
	}


	private MovieService movieService;

	@Mock
	private MovieJpaRepository mockRepository;


	@BeforeEach
	void initUseCase(){
		movieService = new MovieServiceImpl(mockRepository);
	}

	@Test
	void findByIdMocked()
	{
		MovieConverter mapper =new MovieConverter();

		Movie movie = new Movie("ABCD","Dance",4);
		when(mockRepository.findById(1)).thenReturn(java.util.Optional.of(movie));
		assertEquals(movie, mapper.dtoToEntity(movieService.findMovieById(1)));
		Mockito.verify(mockRepository).findById(1);
	}

	@Test
	void getMovie()
	{
		when(mockRepository.findAll()).thenReturn(Stream.of(new Movie("ABCD","Dance",4),new Movie("ABCD","Dance",4)).collect(Collectors.toList()));
		assertEquals(2,movieService.findAllMovies().size());
	}

}
