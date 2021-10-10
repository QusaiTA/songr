package com.songr.songr;

import com.songr.songr.Model.Albums;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SongrApplicationTests {
	Albums albums = new Albums("yeh","Qusai","daddadadada",500,50000);


	@Test
	public void contextLoads() {
	}

	@Test
	public void testCounstucter(){

		Assertions.assertNotNull(albums);
	}

	@Test
	public void testSetter(){
        albums.setSongCount(500);
		assertEquals(500,albums.getSongCount());

	}

	@Test
	public void testGetter(){
		assertEquals("yeh",albums.getTitle());
	}

}
