/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.dubbo.common.utils;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LRUCacheTest {
    @Test
    void testResizeEvictsEldestEntries() {
        LRUCache<String, Integer> cache = new LRUCache<>(3);
        cache.put("one", 1);
        cache.put("two", 2);
        cache.put("three", 3);

        cache.get("one");
        cache.setMaxCapacity(2);

        assertThat(cache.size(), equalTo(2));
        assertTrue(cache.containsKey("one"));
        assertTrue(cache.containsKey("three"));
        assertFalse(cache.containsKey("two"));
    }
}
