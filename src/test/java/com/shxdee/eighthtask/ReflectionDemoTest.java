package com.shxdee.eigthtask;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class ReflectionDemoTest {

    @Test
    public void getHumanCountTest() {
        Human human = new Human("Проскурин", "Евгений", "Юрьевич", 19);
        Human human1 = new Human("Арбузов", "Дмитрий", "Олегович", 18);
        Human human2 = new Human("Телегин", "Матвей", "Александрович", 18);
        Human human3 = new Human("Прикольный", "Антон", "Владимирович", 19);
        Human human4 = new Human("Васильев", "Василий", "Васильевич", 20);

        List<Object> humans = new ArrayList<>();
        humans.add(human); humans.add(human1); humans.add(human2);
        humans.add(human3); humans.add(human4);

        assertEquals(ReflectionDemo.getCountObject(humans), 5);
    }

    @Test
    public void getNamesMethodsTest() {
        Human human = new Human("Проскурин", "Евгений", "Юрьевич", 19);
        List<String> list = new ArrayList<String>(Arrays.asList("getAge", "getClass", "wait", "notifyAll", "compareTo",
                "setPatronymic", "getLastName", "notify", "setLastName", "setFirstName", "hashCode", "equals", "toString",
                "getFirstName", "getPatronymic", "setAge"));
        assertEquals(new HashSet<String>(ReflectionDemo.getNamesMethods(human)), new HashSet<String>(list));
    }

    @Test
    public void getSuperClassesNamesTest() {
        LinkedHashSet<Integer> set = new LinkedHashSet<Integer>();
        List<String> list = new ArrayList<String>(Arrays.asList("java.util.HashSet", "java.util.AbstractSet", "java.util.AbstractCollection", "java.lang.Object"));
        assertEquals(ReflectionDemo.getSuperClassesNames(set), list);
    }

public class AAAAA extends Robot  {

    public AAAAA(int modelNumber) {
        super(modelNumber);
    }
}

    @Test
    public void getCountExecutableClassesTest() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {

        Human human = new Human("Проскурин", "Евгений", "Юрьевич", 19);
        Human human1 = new Human("Арбузов", "Дмитрий", "Олегович", 18);
        Human human2 = new Human("Телегин", "Матвей", "Александрович", 18);
        Human human3 = new Human("Прикольный", "Антон", "Владимирович", 19);
        Human human4 = new Human("Васильев", "Василий", "Васильевич", 20);
        Robot robot1 = new Robot(4000);
        Robot robot2 = new Robot(5000);
        AAAAA aaaaa = new AAAAA(6000);

        List<Object> humansAndRobots = new ArrayList<>();
        humansAndRobots.add(human); humansAndRobots.add(human1); humansAndRobots.add(human2);
        humansAndRobots.add(human3); humansAndRobots.add(human4);
        humansAndRobots.add(robot1); humansAndRobots.add(robot2);
        humansAndRobots.add(aaaaa);

        assertEquals(ReflectionDemo.getCountExecutableClasses(humansAndRobots), 3);
    }

    @Test
    public void getGettersAndSettersTest() {
        Human human = new Human("Проскурин", "Евгений", "Юрьевич", 19);
        List<String> list = new ArrayList<String>(Arrays.asList("getAge", "getClass",
                "setPatronymic", "getLastName", "setLastName", "setFirstName",
                "getFirstName", "getPatronymic", "setAge"));
        assertEquals(new HashSet<String>(ReflectionDemo.getGettersAndSetters(human)), new HashSet<String>(list));
    }
}