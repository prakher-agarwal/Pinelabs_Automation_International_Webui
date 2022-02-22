//package com.pinelabs.RnD.CommonUtils;
//
//import org.testng.asserts.IAssert;
//import org.testng.asserts.SoftAssert;
//import org.testng.asserts.LoggingAssert;
//public class SimpleLoggingAssert implements SimpleLoggingAssert1 {
//    @Override
//    public void onAssertSuccess(IAssert<?> assertCommand) {
//        System.err.println(assertCommand.getMessage() + " <PASSED> ");
//    }
//
//    @Override
//    public void onAssertFailure(IAssert<?> assertCommand, AssertionError ex) {
//        String suffix =
//                String.format(
//                        "Expected [%s] but found [%s]",
//                        assertCommand.getExpected().toString(), assertCommand.getActual().toString());
//        System.err.println(assertCommand.getMessage() + " <FAILED>. " + suffix);
//    }
//}
//}
