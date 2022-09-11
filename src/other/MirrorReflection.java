package other;

//p*ext=q*reflection
public class MirrorReflection {
    public int mirrorReflection(int p, int q) {
        int ext=q, reflection=p;
        while(ext%2==0 && reflection%2==0) {
            ext=ext/2;
            reflection=reflection/2;
        }

        if(ext%2==1 && reflection%2==0) return 2;
        if(ext%2==1 && reflection%2==1) return 1;
        if(ext%2==0 && reflection%2==1) return 0;

        return -1;
    }
}
