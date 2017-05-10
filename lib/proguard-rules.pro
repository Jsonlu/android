-dontusemixedcaseclassnames
-dontskipnonpubliclibraryclasses
-verbose
-dontoptimize
-dontpreverify
-ignorewarnings

-keep public class cn.jsonlu.lib.NetReq.**{*;}
-keep public class cn.jsonlu.lib.NetReq{*;}
-keep public class cn.jsonlu.lib.Config.**{*;}
-keep public class cn.jsonlu.lib.Config{*;}
-keep public class cn.jsonlu.lib.Host{*;}
-keep public class cn.jsonlu.lib.data.**{*;}
-keepclassmembers class cn.jsonlu.lib.NetReq {
   public *;
}

-keepclassmembers public class cn.jsonlu.lib.data.** {
   void set*(***);
   *** get*();
}
