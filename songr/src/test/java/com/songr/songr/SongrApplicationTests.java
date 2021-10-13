package com.songr.songr;

import com.songr.songr.Model.Albums;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SongrApplicationTests {
	Albums albums = new Albums("yeh","Qusai",3,500,"https://etbilarabi.com/sites/default/files/styles/article_landing/public/2020-03/BAFBDC61-35D2-4A4E-A9F6-4C41F1B47403.jpeg?itok=zNDV0gxy");


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
