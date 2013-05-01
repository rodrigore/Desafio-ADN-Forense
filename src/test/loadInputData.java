//package test;
//
//import io.FileRepository;
//
//import org.jmock.Expectations;
//import org.jmock.Mockery;
//import org.junit.Test;
//
//public class loadInputData {
//
//	Mockery context = new Mockery();
//	//Mockery context = new JUnit4Mockery();
//	
//	
//	@Test
//	public void testInputRepositoryLoadData() {
//		final FileRepository file = context.mock( FileRepository.class );
//		context.checking(new Expectations() {{
//		    oneOf (file).load();
//		}});
//	}
//
//}
