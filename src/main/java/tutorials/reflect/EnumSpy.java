package tutorials.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class EnumSpy {
    private static final String fmt = "  %11s:  %s %s%n";

    public static void main(String... args) {
        try {
            Class<?> c = Class.forName("java.util.concurrent.TimeUnit");
            if (!c.isEnum()) {
                out.format("%s is not an enum type%n", c);
                return;
            }
            out.format("Class:  %s%n", c);

            Field[] flds = c.getDeclaredFields();
            List<Field> cst = new ArrayList<Field>();  // enum constants
            List<Field> mbr = new ArrayList<Field>();  // member fields
            for (Field f : flds) {
                if (f.isEnumConstant())
                    cst.add(f);
                else
                    mbr.add(f);
            }
            if (!cst.isEmpty())
                print(cst, "Constant");
            if (!mbr.isEmpty())
                print(mbr, "Field");

            Constructor[] ctors = c.getDeclaredConstructors();
            for (Constructor ctor : ctors) {
                out.format(fmt, "Constructor", ctor.toGenericString(),
                        synthetic(ctor));
            }

            Method[] mths = c.getDeclaredMethods();
            for (Method m : mths) {
                out.format(fmt, "Method", m.toGenericString(),
                        synthetic(m));
            }

            // production code should handle this exception more gracefully
        } catch (ClassNotFoundException x) {
            x.printStackTrace();
        }
    }

    private static void print(List<Field> lst, String s) {
        for (Field f : lst) {
            out.format(fmt, s, f.toGenericString(), synthetic(f));
        }
    }

    private static String synthetic(Member m) {
        return (m.isSynthetic() ? "[ synthetic ]" : "");
    }

}
