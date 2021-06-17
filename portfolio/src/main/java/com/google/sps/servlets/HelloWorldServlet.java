// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.sps.servlets;

import com.google.sps.data.MarcoStats;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Handles requests sent to the /hello URL. */
@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    // Convert data of ArrayList to JSON using GSON
    ArrayList<MarcoStats> marcoList = new ArrayList<MarcoStats>();
    marcoList.add(new MarcoStats(/*age=*/20, /*name=*/"Marco"));
    marcoList.add(new MarcoStats(/*age=*/21, /*name=*/"Xime"));
    marcoList.add(new MarcoStats(/*age=*/26, /*name=*/"Luis"));
    String marcoStatsJson = convertToJson(marcoList);

    // Send the JSON as the response
    response.setContentType("application/json;");
    response.getWriter().println(marcoStatsJson);
  }

  // Function for Converting data to JSON using GSON
  private String convertToJson(ArrayList<MarcoStats> marcoList) {
    Gson gson = new Gson();
    String json = gson.toJson(marcoList);
    return json;
  }
}