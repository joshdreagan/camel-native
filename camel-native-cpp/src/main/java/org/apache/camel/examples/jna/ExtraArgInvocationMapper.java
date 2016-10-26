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
import com.sun.jna.InvocationMapper;
import com.sun.jna.Library;
import com.sun.jna.NativeLibrary;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ExtraArgInvocationMapper implements InvocationMapper {
  
  @Override
  public InvocationHandler getInvocationHandler(NativeLibrary lib, Method m) {
    return new InvocationHandler() {
      @Override
      public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String functionName = method.getName();
        if (lib.getOptions() != null 
                && lib.getOptions().get(Library.OPTION_FUNCTION_MAPPER) != null 
                && lib.getOptions().get(Library.OPTION_FUNCTION_MAPPER) instanceof FunctionMapper) {
          functionName = ((FunctionMapper) lib.getOptions().get(Library.OPTION_FUNCTION_MAPPER)).getFunctionName(lib, method);
        }
        Object[] newArgs = new Object[((args != null) ? args.length : 0) + 1];
        newArgs[0] = null;
        System.arraycopy(args, 0, newArgs, 1, ((args != null) ? args.length : 0));
        return lib.getFunction(functionName).invoke(method.getReturnType(), newArgs, lib.getOptions());
      }
    };
  }
}
