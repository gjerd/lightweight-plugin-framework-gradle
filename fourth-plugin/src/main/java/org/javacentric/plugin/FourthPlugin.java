/*
 *    Copyright 2017 Luke Sosnicki
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package org.javacentric.plugin;

import ljpf.Plugin;

/**
 * Created by souzen on 29.03.2017.
 */
public class FourthPlugin implements Plugin {

    @Override
    public void load() {
        System.out.println("----------------------------------------");
    }

    @Override
    public void unload() {
        System.out.println("----------------------------------------");
    }

}
