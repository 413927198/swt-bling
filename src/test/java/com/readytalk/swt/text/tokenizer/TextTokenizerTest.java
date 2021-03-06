package com.readytalk.swt.text.tokenizer;

import java.nio.charset.Charset;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TextTokenizerTest {
	
	private static final String PLAIN_TEXT = "ABC 123 abc ` ~ ! @ # $ % ^ & * ( \n \t  ) - = _ + { } | \\ ] [ : \" ' ; < > ? / . ,";
	TextTokenizer textTokenizer;
	
	@Before
	public void setup() throws Exception {
		textTokenizer = TextTokenizerFactory.createDefault();
	}
	
	@Test
	public void setEncoding_PassValidEncoding_getEncodingReturnsSameValue() {
		textTokenizer.setEncoding(Charset.defaultCharset());
		Assert.assertSame(Charset.defaultCharset(), textTokenizer.getEncoding());
	}
	
	@Test
	public void getEncoding_UponConstructionDefaultEncodingSet_returnDefaultEncoding() {
		Assert.assertSame(Charset.defaultCharset(), textTokenizer.getEncoding());
	}
	
	@Test
	public void tokenize_MultipleTokenizeCalls_TokenListContainsMoreElements() {
		textTokenizer.tokenize(PLAIN_TEXT);
		textTokenizer.tokenize(PLAIN_TEXT);
		textTokenizer.tokenize(PLAIN_TEXT);
		Assert.assertEquals(4, textTokenizer.tokenize(PLAIN_TEXT).size());
	}
	
	@Test
	public void reset_MultipleTokenizeCalls_ResetClearsInternalList() {
		textTokenizer.tokenize(PLAIN_TEXT);
		textTokenizer.tokenize(PLAIN_TEXT);
		textTokenizer.tokenize(PLAIN_TEXT);
		textTokenizer.reset();
		Assert.assertEquals(1, textTokenizer.tokenize(PLAIN_TEXT).size());
	}
}
