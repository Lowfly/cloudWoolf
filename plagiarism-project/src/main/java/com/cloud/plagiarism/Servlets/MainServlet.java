package com.cloud.plagiarism.Servlets;

import com.cloud.plagiarism.Controllers.SentenceController;
import com.cloud.plagiarism.analyser.Analyser;
import com.cloud.plagiarism.analyser.DB;
import com.cloud.plagiarism.analyser.TextParser;
import com.google.appengine.api.blobstore.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * CO846 Cloud
 * @author Nick
 */

 public class MainServlet extends HttpServlet {

    private BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
    private BlobInfoFactory blobInfoFactory = new BlobInfoFactory();
    private List<String> sentences;
    private DB db;

    // Process the http POST of the form
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        try {

            Map<String, List<BlobKey>> blobs = blobstoreService.getUploads(req);
            List<BlobKey> blobKeys = blobs.get("file");
            if (blobKeys == null || blobKeys.isEmpty()) {
                res.sendRedirect("/");
            } else {
                BlobKey blobKey = blobKeys.get(0);
                BlobInfo blobInfo = blobInfoFactory.loadBlobInfo(blobKey);
                String fileName = blobInfo.getFilename();
                byte[] fileBytes = blobstoreService.fetchData(blobKey, 0, blobInfo.getSize());
                String fileString = new String(fileBytes, req.getParameter("encoding"));

                req.setAttribute("fulltext", fileString);

                DB db = new DB();
                req.setAttribute("fulltext", db.hasError() );
                sentences = (new TextParser(fileString)).getSentencesList();

                SentenceController tmp = new SentenceController();
                tmp.getFromStore("toto");

                String ul = "";
                for(String s : sentences) {
                    ul += "<li>"+s+"</li>";
                }
                ul = "<ul>"+ul+"</ul>";
                req.setAttribute("list", ul);
                req.setAttribute("debug", db.getAll());

                Analyser analyser = new Analyser(sentences, db);
                req.setAttribute("result", "Similarity index is: " + analyser.getSimilarityIndex());
                db.insertAll(sentences);
                try {
                    req.getRequestDispatcher("/upload.jsp").forward(req, res);
                } catch (ServletException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        }
        catch(Exception e) {

            req.setAttribute("message", e.getClass() );
            try {
                req.getRequestDispatcher("/error.jsp").forward(req, res);
            } catch (ServletException e1) {
                res.sendRedirect("/error.jsp");
            }

        }
    }

}
