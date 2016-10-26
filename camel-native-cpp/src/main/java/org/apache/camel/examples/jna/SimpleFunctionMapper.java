/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.examples.jna;

import com.sun.jna.FunctionMapper;
import com.sun.jna.NativeLibrary;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class SimpleFunctionMapper implements FunctionMapper {

  private Map<String, String> functionNameMap = new HashMap<>();

  public Map<String, String> getFunctionNameMap() {
    return functionNameMap;
  }

  public void setFunctionNameMap(Map<String, String> functionNameMap) {
    this.functionNameMap = Objects.requireNonNull(functionNameMap, "The functionNameMap parameter must not be null.");
  }
  
  @Override
  public String getFunctionName(NativeLibrary library, Method method) {
    return functionNameMap.get(method.getName());
  }
}
