/**
 * Copyright 2011-2014 eBusiness Information, Groupe Excilys (www.ebusinessinformation.fr)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 		http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.gatling.core.feeder

import org.junit.runner.RunWith
import org.specs2.mutable.Specification
import org.specs2.runner.JUnitRunner

import io.gatling.core.config.GatlingConfiguration

@RunWith(classOf[JUnitRunner])
class FeederSupportSpec extends Specification with FeederSupport {

  GatlingConfiguration.setUp()

  "tsv" should {

    "handle file without escape char" in {
      val data = tsv("sample1.tsv").build.toArray

      data must beEqualTo(Array(Map("foo" -> "hello", "bar" -> "world")))
    }

    "handle file with escape char" in {
      val data = tsv("sample2.tsv").build.toArray

      data must beEqualTo(Array(Map("foo" -> "hello", "bar" -> "world")))
    }
  }

  "jsonFile" should {

    "handle proper JSON file" in {

      val data = jsonFile("test2.json").build.toArray

      data.size must beEqualTo(2)
      data(0)("id") must beEqualTo(19434)
    }
  }
}
