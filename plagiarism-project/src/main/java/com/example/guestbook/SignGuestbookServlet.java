/**
 * Copyright 2014-2015 Google Inc. All Rights Reserved.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

//[START all]
package com.example.guestbook;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class SignGuestbookServlet extends HttpServlet {

    // Process the http POST of the form
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        System.out.println("\n/**** Request ****/\n");
        System.out.println(req.getParameterMap());
        System.out.println("\n/****  ****/\n");

        DocumentController documentController = new DocumentController("17/12/94", "Ceci est le content de mon PDF");

        //SentenceController sentenceController = new SentenceController("17/12/94", "Ceci est le content de mon PDF");

        //Greeting greeting;


        //greeting = new Greeting("ta soeyr", "coucou");



    /* UserService userService = UserServiceFactory.getUserService();
    User user = userService.getCurrentUser();  // Find out who the user is. */

    /*String guestbookName = req.getParameter("guestbookName");
    String content = req.getParameter("content");*/

    /*if (user != null) {
      greeting = new Greeting(guestbookName, content, user.getUserId(), user.getEmail());
    } else {
      greeting = new Greeting(guestbookName, content);
    }*/

        // Use Objectify to save the greeting and now() is used to make the call synchronously as we
        // will immediately get a new page using redirect and we want the data to be present.


        // greeting = new Greeting("ta soeyr", "coucou");



    /* UserService userService = UserServiceFactory.getUserService();
    User user = userService.getCurrentUser();  // Find out who the user is. */

    /*String guestbookName = req.getParameter("guestbookName");
    String content = req.getParameter("content");*/

    /*if (user != null) {
      greeting = new Greeting(guestbookName, content, user.getUserId(), user.getEmail());
    } else {
      greeting = new Greeting(guestbookName, content);
    }*/

        // Use Objectify to save the greeting and now() is used to make the call synchronously as we
        // will immediately get a new page using redirect and we want the data to be present.
        //

        //System.out.println("document");

        documentController.uploadDocument();
        documentController.downloadDocument(documentController.getDocument().getDocId());

        resp.sendRedirect("/upload.jsp");
    }
}
//[END all]
