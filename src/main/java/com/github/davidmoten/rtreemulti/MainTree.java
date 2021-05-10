package main.java.com.github.davidmoten.rtreemulti;

import com.github.davidmoten.rtreemulti.geometry.Point;
import java.util.List;

public class MainTree {

    //These are only the dimensions that the tree will be built upon
    private static final List<Entry<Object, Point>> dimension_entries = MainTreeData.entriesList();
    //These are all the attributes in the data
    private static final List<Entry<Object, Point>> attribute_entries = MainTreeData.entriesList2();

    //total number of data points
    private static int size=10000;

    //max nr of children
    private static int maxChildren=4;

    //Create an R* tree with the dimension entries. Change the maxChildren, minChildren, dimensions as required.
    private static final RTree<Object, Point> tree = RTree.maxChildren(4).minChildren(2).dimensions(2).star().<Object, Point>create().add(dimension_entries);

    //For testing purposes, the result will be saved in .csv file on IntelliJ
    public static void main(String[] args) {

        // The below output will be saved in a .csv file
        // IntelliJ->Run->Configurations->Logs->Save console output to .csv file
        System.out.println(tree.asString3(tree, attribute_entries));

        //Creates the rectangles representation in the target folder.
        tree.visualize(600, 600)
                .save("target/rtreee_" + size + "_" + maxChildren + "_data.png");
    }
}
