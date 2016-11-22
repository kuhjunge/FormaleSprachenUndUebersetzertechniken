package rekursiverAbstieg;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

public class RekAbstNGTest {
	final String end = "\n";
	
	@Test(dataProvider = "dpParserErr")
	public void testParserErr(String str) {
		Lexer lexer = new RecursiveDecentLexer(str);
		RecursiveDecentParser parser = new RecursiveDecentParser(lexer);
		Assert.assertNotNull(parser);
		Boolean isFail = true; 

		try {
			parser.statlist();
		} catch (Throwable e) {
			System.out.println("Test Fehlverarbeitung: "+e.getMessage());
			isFail = false;
		}
		if (isFail){
			Assert.fail();
		}
	}

	@DataProvider
	public Object[][] dpParserErr() {
		return new Object[][] { 
			new Object[] { "10 + 20 + " + this.end },
			new Object[] { "10 / 20 * " + this.end },
			new Object[] { "10 - 20 " },
			new Object[] { "10  20 " + this.end },
			new Object[] { "10 add 20 " + this.end },
				};
	}
	
	@Test(dataProvider = "dpParser")
	public void testParser(String str) {
		Lexer lexer = new RecursiveDecentLexer(str);
		RecursiveDecentParser parser = new RecursiveDecentParser(lexer);
		Assert.assertNotNull(parser);
		parser.statlist();
	}

	@DataProvider
	public Object[][] dpParser() {
		return new Object[][] { 
			new Object[] { "10 - 20 " + this.end },
			new Object[] { "10 + 20 " + this.end },
			new Object[] { "10 - 22 " + this.end },
			new Object[] { "10 * 20 " + this.end },
			new Object[] { "10 / 20 " + this.end },
			new Object[] { "- 20  " + this.end },
			new Object[] { "+ 20 " + this.end },
			new Object[] { "5 + (10 - 23)" + this.end },
			new Object[] { "(10 - 23)" + this.end },
			new Object[] { "1 + 2 + 3" + this.end },
			new Object[] { "		 20 	 " + this.end },
			new Object[] { "(10 - 20) * 525" + this.end }, 
			new Object[] { " 3 + 4 * 5" + this.end},
			new Object[] { " ( 3 + 4 ) * 5" + this.end},
			new Object[] { " 1 + 2  + (5 * 4) + 5" + this.end},
			new Object[] { " 5 / 4" + this.end},
			new Object[] { " 1 + 2 + 3" + this.end}, 
		};	
		
	}

	@Test(dataProvider = "dpLexer")
	public void testLexer(String s, String comp) {
		int i = 0;
		Lexer lexer = new RecursiveDecentLexer(s);
		Assert.assertNotNull(lexer);
		String[] erg = comp.split(";");
		Token t = lexer.nextToken();
		Assert.assertNotNull(t);
		Assert.assertEquals(t.toString(), erg[i].toString());
		while (t.type != Lexer.EOF_TYPE) {
			i++;
			//System.out.println(t);
			t = lexer.nextToken();
			Assert.assertEquals(t.toString(), erg[i]);
		}
		//System.out.println(t); // EOF
	}

	@DataProvider
	public Object[][] dpLexer() {
		return new Object[][] {
				new Object[] { "10 + 20 " + this.end, "<'10',INTEGER>;<'+',PLUS>;<'20',INTEGER>;<'\\n',NL>;<'<EOF>',EOF>" },
				new Object[] { "10 - 20 " + this.end, "<'10',INTEGER>;<'-',MINUS>;<'20',INTEGER>;<'\\n',NL>;<'<EOF>',EOF>" },
				new Object[] { "10 * 20 " + this.end, "<'10',INTEGER>;<'*',MULTI>;<'20',INTEGER>;<'\\n',NL>;<'<EOF>',EOF>" },
				new Object[] { "10 / 20 " + this.end, "<'10',INTEGER>;<'/',DIV>;<'20',INTEGER>;<'\\n',NL>;<'<EOF>',EOF>" },
				new Object[] { "- 20  " + this.end, "<'-',MINUS>;<'20',INTEGER>;<'\\n',NL>;<'<EOF>',EOF>" },
				new Object[] { "+ 20 " + this.end, "<'+',PLUS>;<'20',INTEGER>;<'\\n',NL>;<'<EOF>',EOF>" },
				new Object[] { "(10 - 20) * 525" + this.end,
						"<'(',LBRACK>;<'10',INTEGER>;<'-',MINUS>;<'20',INTEGER>;<')',RBRACK>;<'*',MULTI>;<'525',INTEGER>;<'\\n',NL>;<'<EOF>',EOF>" }, };
	}
}
