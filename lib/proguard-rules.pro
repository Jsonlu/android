-dontusemixedcaseclassnames
-dontskipnonpubliclibraryclasses
-verbose
-dontoptimize
-dontpreverify
-ignorewarnings

-keep public class cn.jsonlu.lib.service.net.NetReq.**{*;}
-keep public class cn.jsonlu.lib.service.net.NetReq{*;}
-keep public class cn.jsonlu.lib.Config.**{*;}
-keep public class cn.jsonlu.lib.Config{*;}
-keep public class cn.jsonlu.lib.service.net.Host{*;}
-keep public class cn.jsonlu.demo.data.**{*;}
-keepclassmembers class cn.jsonlu.lib.service.net.NetReq {
   public *;
}

-keepclassmembers public class cn.jsonlu.demo.data.** {
   void set*(***);
   *** get*();
}
