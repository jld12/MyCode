using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HelloWorld
{
    class Program
    {
        static void Main(string[] args)
        {

            Console.WriteLine("Hello, world! Enter your name.");
            String userName = Console.ReadLine();
            Console.WriteLine("\nWould you like to hear a joke, " + userName + "? Type y for 'yes'.");
            String userInput = Console.ReadLine();
            
            if (userInput.Equals("y"))
            {

                Random rand = new Random();
                int randNum = rand.Next(5);

                switch (randNum)
                {

                    case 0:
                        Console.WriteLine("\nWhat did the boy say when his brother stole his Doritos?");
                        Console.ReadKey();
                        Console.WriteLine("That's nacho cheese!");
                        break;

                    case 1:
                        Console.WriteLine("\nWhat did the grape do when he didn't get his way?");
                        Console.ReadKey();
                        Console.WriteLine("He 'wined'!");
                        break;

                    case 2:
                        Console.WriteLine("\nThere are 10 types of people in the world...");
                        Console.ReadKey();
                        Console.WriteLine("\nThose who understand binary and those who don't.");
                        break;

                    case 3:
                        Console.WriteLine("\nMy wife said she thought my gift sucked...");
                        Console.ReadKey();
                        Console.WriteLine("I said, 'I'm glad you like your new vacuum cleaner!'");
                        break;

                    default:
                        Console.WriteLine("\nHow could you describe a space restaurant?");
                        Console.ReadKey();
                        Console.WriteLine("Great food-but no atmosphere!");
                        break;

                }

                Console.WriteLine("\nI hope you like dad jokes! Thanks for listening!");

            } else
            {
                Console.WriteLine("\nThat's too bad. Have a nice day! Press any key to exit.");
            }

            Console.WriteLine("Press any key to exit.");
            Console.ReadKey();

        }
    }
}
