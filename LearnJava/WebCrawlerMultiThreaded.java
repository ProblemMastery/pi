package LearnJava;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class WebCrawlerMultiThreaded  {

    public List<String> crawl(String startUrl, HtmlParser htmlParser){

        int index = startUrl.indexOf('/', 7);
        String hostname = (index != -1) ? startUrl.substring(0, index) : startUrl;

        //multi thread

        Crawler crawler = new Crawler(startUrl, hostname,  htmlParser);
        crawler.map = new ConcurrentHashMap<>();
        crawler.result = crawler.map.newKeySet();
        Thread thread = new Thread(crawler);
        return Collections.EMPTY_LIST;
    }

}
