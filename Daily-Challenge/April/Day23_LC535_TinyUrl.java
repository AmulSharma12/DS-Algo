// https://leetcode.com/problems/encode-and-decode-tinyurl/
// LeetCode LC535 Medium Tiny URl 

public class Codec {
    private Map<String ,String> mp = new HashMap<>();
    private String url = "http://tinyurl.com/";
    private int num = 0;
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String shortUrl = url + Integer.toString(num);
        num++;
        this.mp.put(shortUrl, longUrl);
        System.out.println(shortUrl);
        return shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        System.out.println(mp.get(shortUrl));
        return mp.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));