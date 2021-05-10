# rstartree_multiple
original R* Tree from @ davidmoten modified to output extra information per node

New classes added: MainTree, MainTreeData. Class modified: RTree.

HOW TO RUN:

1. Currently the data to build the tree is being read from a zipped .txt file. The file only contains the dimension attributes to build the tree and the friction attribute to calculate the count, linear sum and square sum. In the future make the tree to read the data directly from the database. Drop the .tzt.gz file under src>main>resources where all the other files of data are.

2. On MainTree.java specify the max. number of children, min. number of children and the number of dimensions to build the tree as below:

private static final RTree<Object, Point> tree = RTree.maxChildren(4).minChildren(2).dimensions(2).star().<Object, Point>create().add(dimension_entries);

3. On MainTreeData.java add the path of the file in the entries() and all_entries() method as below:

 MainTreeData.class.getResourceAsStream("/segment403data.txt.gz"))
 
 entries() method formats the data for the tree. If you want to add more dimensions to the tree, add code line as below:
 
 double dimension_n = Double.parseDouble(items[n]);   where n=dimension counter
 
 Repeat the same steps for the all_entries() method. This method is not used to build the tree, it creates a list of entries with the friction attribute added (last attribute in the file). 
 BUG: Currently the tree is not saving the friction count/linear sum/square sum on each node, it is calculating all the informatin in the end when the tree is already built. In the future add the friction count/linear sum/square sum in the node while the tree is being built and not in the end of the process. 
 
4. RUN Maintree.java. The output is saved a .csv file on IntelliJ (IntelliJ->Run->Configurations->Logs->Save console output to .csv file). In the future add the output directly to the database similarly to the temporal granulation code. 
