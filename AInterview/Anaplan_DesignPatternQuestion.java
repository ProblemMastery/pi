//package AInterview;
//
//import java.io.FileNotFoundException;
//
////
//public class Anaplan_2 {
//
//    public interface Storage{
//
//        public String getFile(String filename) throws FileNotFoundException;
//
//        public void putFile(String filename, String fileContents);
//
//        public boolean deleteFile(String filename) throws FileNotFoundException;
//    }
//
//    public class s3 implements Storage {
//
//
//        @Override
//        public String getFile(String filename) throws FileNotFoundException{
//            return null;
//        }
//
//        @Override
//        public void putFile(String filename, String fileContents) {
//
//        }
//
//        @Override
//        public boolean deleteFile(String filename) throws FileNotFoundException, IllegalStateException{
//            return false;
//        }
//    }
//
//    // delete
//    //
//    public interface Command {
//
//        enum  commandType {
//            GET,
//            PUT,
//        DELETE
//        };
//        public void execute(Storage s);
//
//
//    }
//
//    public class GetandDeleteRequest implements Command {
//
//        String filename;
//
//        public GetandDeleteRequest (String filename){
//            this.filename = filename;
//        }
//
//        public void execute(Storage s) throws FileNotFoundException{
//            try {
//                //get
//
//                String fileContents = s.getFile(filename);
//                boolean isFileDeleted = s.deleteFile(filename);
//
//
//            }catch (FileNotFoundException f) {
//                throw f;
//            }
//        }
//    }
//    public interface Executor {
//        public void execute(Command c);
//
//    }
//    public class Executor_1 implements Executor{
//
//        Storage s;
//        public Executor_1(Storage s){
//            this.s = s;
//        }
//        public void execute(Command c){
//            c.execute(s);
//
//        }
//    }
//
//    public class clientStorage{
//
//       // @Autowired
//        private Executor e;
//
//        public String getAndDelete(String filename)  {
//
//            try {
//                //get
//                Command c = new GetandDeleteRequest(filename);
//               e.execute(c);
//
//            }catch (FileNotFoundException f) {
//                throw f;
//            }
//
//
//        }
//
//    }
//
//    public static void main(String[] args){
//
//    }
//}
