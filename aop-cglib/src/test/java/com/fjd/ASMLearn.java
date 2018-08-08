package com.fjd;


import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.util.TraceClassVisitor;
import jdk.internal.org.objectweb.asm.ClassWriter;


import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import static org.objectweb.asm.Opcodes.*;

public class ASMLearn {
    public static void main(String[] args) throws Exception {
        ClassWriter cw = new ClassWriter(0);
        PrintWriter printWriter = new PrintWriter(System.out);
        TraceClassVisitor visitor = new TraceClassVisitor(cw, printWriter);

        visitor.visit(V1_5, ACC_PUBLIC, "asm/demo/AddOperImpl", null, "java/lang/Object", new String[]{"asm/demo/AddOper"});

        //添加构造方法
        MethodVisitor mv = visitor.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
        mv.visitCode();
        mv.visitVarInsn(ALOAD, 0);
        mv.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V");
        mv.visitInsn(RETURN);
        mv.visitMaxs(1, 1);
        mv.visitEnd();

        // 添加add方法
        mv = visitor.visitMethod(ACC_PUBLIC, "add", "(II)I", null, null);
        mv.visitCode();
        mv.visitVarInsn(ILOAD, 1);
        mv.visitVarInsn(ILOAD, 2);
        mv.visitInsn(IADD);
        mv.visitInsn(IRETURN);
        mv.visitMaxs(2, 3);
        mv.visitEnd();

        visitor.visitEnd();

        FileOutputStream fos = new FileOutputStream(new File("C:/code/AddOperImpl.class"));
        fos.write(cw.toByteArray());
        fos.close();
    }
}