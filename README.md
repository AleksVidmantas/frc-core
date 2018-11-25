# frc-core
Core robot code that can be used every year implementing GradleRio's IDE agnostic setup.  
## The philosophy while designing the code base is as follows in descending importance:
1. Readability - FRC is aimed at coders who have JUST picked up programming.  If the code isn't
readable by noobs, the point of FRC is kinda already lost.  The codebase is designed to be picked up
as quickly as possible, using as few tricks as possible.

2. Maintainablity/Flexibility/Hotswapping - designing code that can be quickly replaced and changed in as few
places as possible enforces point 2, 3, and 4.

3. DRY - Don't Repeat Yourself - This is one of the pillars that nearly all coders follow.  Coding
should make your job easier.  If you find yourself writing looong lines of code or nested for loops inside
of switch statements, stop; ask yourself, "Why?", and make it simpler.

4. Modern Code Standards - This comes last as the following cover many code standards already.  First is often times
students' first run-in with programming.  By enforcing standards (found on our team page) sets students up for success.
