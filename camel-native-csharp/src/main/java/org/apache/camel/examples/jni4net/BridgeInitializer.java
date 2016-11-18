package org.apache.camel.examples.jni4net;

import java.io.File;
import java.util.List;
import net.sf.jni4net.Bridge;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BridgeInitializer {

  private static final Logger log = LoggerFactory.getLogger(BridgeInitializer.class);
  
  private List<File> assemblies;

  public List<File> getAssemblies() {
    return assemblies;
  }

  public void setAssemblies(List<File> assemblies) {
    this.assemblies = assemblies;
  }

  public void start() throws Exception {
    Bridge.init();
    for (File f : assemblies) {
      log.debug(String.format("Loading %s", f));
      Bridge.LoadAndRegisterAssemblyFrom(f);
    }
  }

  public void stop() throws Exception {
  }
}
