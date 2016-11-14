package rekursiverAbstieg;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

public class RekAbstNGTest {
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
			System.out.println(t);
			t = lexer.nextToken();
			Assert.assertEquals(t.toString(), erg[i]);
		}
		System.out.println(t); // EOF
  }

  @Test
  public void testParser() {
		Lexer lexer = new RecursiveDecentLexer(" 5 + (10 - 23)\n");
		RecursiveDecentParser parser = new RecursiveDecentParser(lexer);
		Assert.assertNotNull(parser);
		
		parser.statlist();

  }
  
  @DataProvider
  public Object[][] dpLexer() {
	final String end = "\n";
    return new Object[][] {
      new Object[] {"10 + 20 " + end, "<'10',INTEGER>;<'+',PLUS>;<'20',INTEGER>;<'\\n',NL>;<'<EOF>',EOF>"},
      new Object[] {"10 - 20 " + end, "<'10',INTEGER>;<'-',MINUS>;<'20',INTEGER>;<'\\n',NL>;<'<EOF>',EOF>"},
      new Object[] {"10 * 20 " + end, "<'10',INTEGER>;<'*',MULTI>;<'20',INTEGER>;<'\\n',NL>;<'<EOF>',EOF>"},
      new Object[] {"10 / 20 " + end, "<'10',INTEGER>;<'/',DIV>;<'20',INTEGER>;<'\\n',NL>;<'<EOF>',EOF>"},
      new Object[] {"- 20  " + end, "<'-',MINUS>;<'20',INTEGER>;<'\\n',NL>;<'<EOF>',EOF>"},
      new Object[] {"+ 20 " + end, "<'+',PLUS>;<'20',INTEGER>;<'\\n',NL>;<'<EOF>',EOF>"},
      new Object[] {"(10 - 20) * 525 + A6D " + end, "<'(',LBRACK>;<'10',INTEGER>;<'-',MINUS>;<'20',INTEGER>;<')',RBRACK>;<'*',MULTI>;<'525',INTEGER>;<'+',PLUS>;<'A6D',ID>;<'\\n',NL>;<'<EOF>',EOF>"},
    };
  }
}
