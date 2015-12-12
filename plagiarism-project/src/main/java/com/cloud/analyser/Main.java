/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nick
 */
/* public class Main {
    
    public Main() {
        
            String filepath = getUploadFilePath();
            PDFParser parser = new PDFParser(filepath);
            List<String> sentences = parser.getSentencesList();
            DB db = new DB(db_connection_details);
            
            
            Thread t1 = new Thread(new Runnable() {
                public void run() {
                    Analyser analyser = new Analyser( sentences, db );
                    analyser.getSimilarityIndex();
                }
            });
            Thread t2 = new Thread(new Runnable() {
                public void run() {
                   db.insertAll( sentences );
                }
            });
            
            t1.start();
            t2.start();
            
            
    }
        
    }
    
}*/
