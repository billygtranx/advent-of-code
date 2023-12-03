# advent-of-code
My goal for doing advent of code this year is to become proficient in Java and be able to use it to develop complex applications with the same level of proficiency and skill that I have with C#.

## day 1
Part 1 I had trouble trying to code like how I would in C#. I spent considerable time exploring if I could emulate regex functions akin to those in C# and return a group of matches.

Part 2 My overly simplistic regex gave me a bit of trouble now that it had to capture more than `/\d/` I had to make use of the matcher and a lot of trouble came of the many edge cases that I had to account for such as `eighthree` so my regex has to first catch those cases and depending on location parse either 8 or 3. To be done with it I added switch cases to match for the edge cases as I could spend days attempting to find more elegant solutions. 

## day 2
Day 2 was a much easier problem than Day1 in that there are not many edge cases to account for there was a snag in which I misunderstood the constraints to be per game rather than a session per game that had me tied up for a little bit. Once part 1 was done most of the code could be used for part 2 to solve for an answer very quickly. I'm also trying out Copilot and gradle to see how these tools are helpful to me.