/*
 * Copyright (c) 2017 - sikulix.com - MIT license
 */

package com.sikulix.tool;

import com.sikulix.core.Content;
import com.sikulix.core.SX;
import com.sikulix.core.SXLog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Sikulix {

  //<editor-fold desc="housekeeping">
  static SXLog log;

  static String stars = repeat("*", 50);

  public static String repeat(String str, int count) {
    return String.format("%0" + count + "d", 0).replace("0", str);
  }

  private static void traceBlock(String message) {
    log.trace(stars);
    log.trace("*****   %s", message);
    log.trace(stars);
  }

  static List<String> options = new ArrayList<>();
  //</editor-fold>

  public static void main(String[] args) {
    log = SX.getSXLog("SX_Sikulix_Tool");
    options.addAll(Arrays.asList(args));
    if (options.contains("trace")) {
      options.remove("trace");
      log.globalOn(SXLog.TRACE);
    }
    String sargs = "";
    for (String option : options) {
      sargs += " " + option;
    }
    log.trace("main: start: %s", sargs);

    new Tool();
  }
}
