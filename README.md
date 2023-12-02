# advent-of-code
My goal for doing advent of code this year is to become proficient in Java and be able to use it to develop complex applications with the same level of proficiency and skill that I have with C#.

## day 1
Part 1 I had trouble trying to code like how I would in C#. Alot of my time was spent seeing if I could mimic regex functions similar to C# and return a group of matches.

Part 2 My overly simplistic regex gave me a bit of trouble now that it had to capture more than `/\d/` I had to make use of the matcher and a lot of trouble came of the many edge cases that I had to account for such as eighthree so my regex has to first catch those cases and depending on location parse either 8 or 3. To be done with it I added switch cases to match for the edge cases as I could spend days attempting to find more elegant solutions. 