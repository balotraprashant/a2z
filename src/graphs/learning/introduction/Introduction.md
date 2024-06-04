Problem Link: https://www.geeksforgeeks.org/problems/graph-and-vertices/1

## Introduction to Graph

**What is a graph data structure?**

There are two types of data structures:

- Linear
- Non - linear

We are aware of linear data structures such as arrays, stacks, queues, and linked lists. They are called linear because data elements are arranged in a linear or sequential manner.

The only non-linear data structure that we’ve seen so far is Tree. In fact, a tree is a special type of graph with some restrictions. Graphs are data structures that have a wide-ranging application in real life. These include analysis of electrical circuits, finding the shortest routes between two places, building navigation systems like Google Maps, even social media using graphs to store data about each user, etc. To understand and use the graph data structure, let’s get familiar with the definitions and terms associated with graphs.

**Definitions and Terminology**

- A graph is a non-linear data structure consisting of nodes that have data and are connected to other nodes through edges.

![image](https://github.com/balotraprashant/a2z/assets/69639884/33fa05ba-f979-4f73-ba09-c75cf08e0a38)

- **Nodes** are circles represented by numbers. Nodes are also referred to as vertices. They store the data. The numbering of the nodes can be done in any order, no specific order needs to be followed.

- In the following example, the number of nodes or vertices = 5

![image](https://github.com/balotraprashant/a2z/assets/69639884/34c25442-c39f-480e-91c2-e1c6622ead33)

- Two nodes are connected by a horizontal line called **Edge**. Edge can be directed or undirected. Basically, pairs of vertices are called edges.

- In the above example, the edge can go from 1 to 4 or from 4 to 1, i.e. a bidirectional edge can be in both directions, hence called an **undirected** edge. Thus, the pairs (1,4) and (4,1) represent the same edge.

**Types of Graphs**

![image](https://github.com/balotraprashant/a2z/assets/69639884/24290c7d-d099-41b5-9540-697a1c4cda08)

- An undirected graph is a graph where edges are bidirectional, with no direction associated with them, i.e, there will be an undirected edge. In an undirected graph, the pair of vertices representing any edge is unordered. Thus, the pairs (u, v) and (v, u) represent the same edge.

- A directed graph is a graph where all the edges are directed from one vertex to another, i.e, there will be a directed edge. It contains an ordered pair of vertices. It implies each edge is represented by a directed pair <u, v>. Therefore, <u, v> and <v, u> represent two different edges.

There can be multi-directed edges, hence bidirectional edges, as shown in the example below.

![image](https://github.com/balotraprashant/a2z/assets/69639884/5438b597-466c-4ea7-8488-904fcd0202c5)

### Structure of Graph

Does every graph have a cycle? 

The answer is No! Let us consider the following examples to understand this.

![image](https://github.com/balotraprashant/a2z/assets/69639884/26163e1f-c9b8-4dd7-a1c9-4eacc9b2536f)

Fig. 1 does not form a cycle but still, it is a graph. 

Fig. 2 is an example of a binary tree. It can also be called a graph because it follows all the rules. We’ve nodes and edges, and this is the minimal condition to be called a graph. 

So a graph does not necessarily mean to be an enclosed structure, it can be an open structure as well. A graph is said to have a cycle if it starts from a node and ends at the same node. There can be multiple cycles in a graph.

![image](https://github.com/balotraprashant/a2z/assets/69639884/6695dd3b-3683-4421-b636-8ef7a3f56a36)

If there is at least one cycle present in the graph then it is called an **Undirected Cyclic Graph**.

In the following examples of directed graphs, the first directed graph is not cyclic as we can’t start from a node and end at the same node. Hence it is called Directed Acyclic Graph, commonly called **DAG**.

![image](https://github.com/balotraprashant/a2z/assets/69639884/88768a66-69d5-41fc-bff3-ffdd0fe5f159)

If we just add an edge to the directed graph, then at least one cycle is present in the graph, hence it becomes **Directed Cyclic Graph.**

**Path in a Graph**

![image](https://github.com/balotraprashant/a2z/assets/69639884/26bc019d-2ab1-426b-bdd5-b4cd0611efd0)

The path contains a lot of nodes and each of them is reachable.

Consider the given graph,

![image](https://github.com/balotraprashant/a2z/assets/69639884/48431b75-254e-47be-9e6a-ff213d194a66)

```
1 2 3 5 is a path.
1 2 3 2 1 is not a path, because a node can’t appear twice in a path.
1 3 5 is not a path, as adjacent nodes must have an edge and there is no edge between 1 and 3.
```

**Degree of Graph**

It is the number of edges that go inside or outside that node.

For **undirected graphs**, the degree is the number of edges attached to a node.

```
Example, 
D(3) = 3
D(4) = 2
```

![image](https://github.com/balotraprashant/a2z/assets/69639884/6ee3354f-d4c1-418d-971e-8c3a6cd893b4)

**Property:** It states that the total degree of a graph is equal to twice the number of edges. This is because every edge is associated/ connected to two nodes.

![image](https://github.com/balotraprashant/a2z/assets/69639884/09c1e276-6aea-4e6f-b43a-102d4f7a4c84)

```
Total Degree of a graph = 2 x E
Example, (2+2+3+2+3) = 2 x 6 => 12 = 12
```

![image](https://github.com/balotraprashant/a2z/assets/69639884/5f3906d0-97a8-408e-b35f-1e4a8fd16853)

For **directed graphs**, we’ve Indegree and Outdegree. The indegree of a node is the number of incoming edges. The outdegree of a node is the number of outgoing edges.

**Edge Weight**

A graph may have weights assigned on its edges. It is often referred to as the cost of the edge.

![image](https://github.com/balotraprashant/a2z/assets/69639884/fbb7b496-771e-4b17-9dd7-54b8cb722be3)

If weights are not assigned then we assume the unit weight, i.e, 1. In applications, weight may be a measure of the cost of a route. For example, if vertices A and B represent towns in a road network, then weight on edge AB may represent the cost of moving from A to B, or vice versa.
