# advent-of-code
My goal for doing advent of code this year is to become proficient in Java and be able to use it to develop complex applications with the same level of proficiency and skill that I have with C#.

## day 1
Part 1 I had trouble trying to code like how I would in C#. I spent considerable time exploring if I could emulate regex functions akin to those in C# and return a group of matches.

Part 2 My overly simplistic regex gave me a bit of trouble now that it had to capture more than `/\d/` I had to make use of the matcher and a lot of trouble came of the many edge cases that I had to account for such as `eighthree` so my regex has to first catch those cases and depending on location parse either 8 or 3. To be done with it I added switch cases to match for the edge cases as I could spend days attempting to find more elegant solutions. 

## day 2
Day 2 was a much easier problem than Day1 in that there are not many edge cases to account for there was a snag in which I misunderstood the constraints to be per game rather than a session per game that had me tied up for a little bit. Once part 1 was done most of the code could be used for part 2 to solve for an answer very quickly. I'm also trying out Copilot and gradle to see how these tools are helpful to me.

## day 3
Almost everything that could go wrong did. Keeping each day to a seperate project caused me alot of pain in configuring vscode to actually build correctly. The base of the project is different from the launch.json and the build.gradle causing me alot of pain in figuring out why i can build from the command line but not vscode. I abused the use of copilot to almost an undeserved solving of the challenge, i'm surprised in how much you can turn your brain off if you correctly prompt code pilot. I had the idea of tracking 3 lines of the file the previous, current and next line and checking indexes on those three lines for numbers but was struggling at actual implmentation of that. I was surprised how much code was generate when given a prompt like this:
```
while reading each line keep track of the current line and the previous line and the next line and check thier indexes to see if any digit characters are adjacent or diagnal to the special characters, if they are find numbers those digits are connected to and add them to a list
```
it created almost 90 percent of the solution. Previously i thought Copilot to be almost useless, but as it turns out having the Copilot Chat extension allows for complex contextual prompts for generating code and makes it quite worth it.