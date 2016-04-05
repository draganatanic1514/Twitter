package com.twitter;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.twitter.poruke.TwitterPoruka;

public class TwitterTest {
	
	Twitter t;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		t = new Twitter();
	}

	@After
	public void tearDown() throws Exception {
		t = null;
	}

	@Test
	public void testVratiSvePoruke() {
		t.unesi("Dragana", "Cao");
		t.unesi("Milica", "Pozdrav");
		t.unesi("Novak", "Lep dan");
		
		assertEquals("Dragana", t.vratiSvePoruke().get(0).getKorisnik());
		assertEquals("Cao", t.vratiSvePoruke().get(0).getPoruka());
		assertEquals("Milica", t.vratiSvePoruke().get(1).getKorisnik());
		assertEquals("Pozdrav", t.vratiSvePoruke().get(1).getPoruka());
		assertEquals("Novak", t.vratiSvePoruke().get(2).getKorisnik());
		assertEquals("Lep dan", t.vratiSvePoruke().get(2).getPoruka());
	}

	@Test
	public void testUnesi() {
		t.unesi("Aleksandra", "Pozdrav");
		
		assertEquals("Aleksandra", t.vratiSvePoruke().get(0).getKorisnik());
		assertEquals("Pozdrav", t.vratiSvePoruke().get(0).getPoruka());
	}

	@Test
	public void testVratiPoruke() {
		t.unesi("Dragana", "Draganina poruka");
		t.unesi("Milica", "Milicina poruka");
		t.unesi("Novak", "Novakova poruka");
		
		TwitterPoruka[] tp = new TwitterPoruka[2];
		
		tp[0] = new TwitterPoruka();
		tp[1] = new TwitterPoruka();
		
		tp[0].setKorisnik("Dragana");
		tp[0].setPoruka("Draganina poruka");
		tp[1].setKorisnik("Milica");
		tp[1].setPoruka("Milicina poruka");
		
		assertArrayEquals(tp, t.vratiPoruke(2, "poruka"));
	}
	
	@Test(expected = java.lang.RuntimeException.class)
	public void testVratiPorukeTagNull() {
		t.vratiPoruke(8, null);
	}
	
	@Test(expected = java.lang.RuntimeException.class)
	public void testVratiPorukeTagPrazanString() {
		t.vratiPoruke(8, "");
	}
}
