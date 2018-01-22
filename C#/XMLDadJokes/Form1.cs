using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Xml;

namespace WindowsFormsApp1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();

            cbNum.SelectedIndex = 0;

        }

        private void btnSubmit_Click(object sender, EventArgs e)
        {

            if (cbNum.SelectedIndex != 0) 
            {

                int numJokes = cbNum.SelectedIndex;
                lblJokes.Text = numJokes + " jokes selected.\n";

                XmlTextReader reader = new XmlTextReader("jokes.xml");

                while (reader.Read())
                {
                    if (numJokes > 0)
                    {

                        lblJokes.Text += "Jokes!\n";

                        numJokes--;

                    } 
                }

                lblJokes.Text += "\nThanks for hearing bad jokes!";

            } else
            {

                lblJokes.Text = "Oh. I see how it is.";

            }
            

        }

        private void cbNum_SelectedIndexChanged(object sender, EventArgs e)
        {

        }
    }
}