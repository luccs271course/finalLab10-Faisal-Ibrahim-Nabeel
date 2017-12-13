# COMP 271 002 F17 Lab 10

## Answers:
##### Written part: Discuss the differences among the results. Does the starting point make a difference?

Yes the starting point make a difference.

- BreadthFirstIterator and ClosestFirstIterator have the same order resulting iteration sequence

- DepthFirstIterator have the opposite resulting iteration sequence than BreadthFirstIterator.

- However in RandomWalkIterator, the resulting iteration sequence is different each time.

##### Written part: Give two or three examples of how/why a real-world map might require more than four colors.
1.    In the real-world countries or territories may not be continuous, for example the US has 48 continuous states, Alaska, Hawaii and many other territories are still considered part of America but not connected; other examples could include Russia, Spain and etc.
2.    Another limitation is that water regions that beyond to certain countries cannot be colored differently, almost all maps have water as blue. So, any water area i.e., lakes, rivers, seas and oceans must be blue. So, although the color blue can be used for water but cannot be used by a country as that would cause confusion. Also, rivers run through many countries, like the Nile or the Indus.
All of these limitations and more make it difficult to use four colors for a real-world map. It also depends on what the maps is trying to show. If it is a political map of democratic and republican states, only two colors are needed. If the map intends to show topographical features, divisions of states and countries it may require more than four colors.

### Notes:
##### - We could not use the GoogleJavaFormat.
##### - There were many commits however, a member accidently used Java version 9 to compile the code and pushed to the older repo after doing some work. Therefore, we had to migrate to a new repo in order to fix that issue.
###### Here's a link to out older repo: https://github.com/luccs271course/Lab10-Faisal-Ibrahim-Nabeel.git