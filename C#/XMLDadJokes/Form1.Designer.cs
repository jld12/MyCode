namespace WindowsFormsApp1
{
    partial class Form1
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.btnSubmit = new System.Windows.Forms.Button();
            this.label1 = new System.Windows.Forms.Label();
            this.lblJokes = new System.Windows.Forms.Label();
            this.cbNum = new System.Windows.Forms.ComboBox();
            this.SuspendLayout();
            // 
            // btnSubmit
            // 
            this.btnSubmit.Location = new System.Drawing.Point(203, 52);
            this.btnSubmit.Name = "btnSubmit";
            this.btnSubmit.Size = new System.Drawing.Size(75, 23);
            this.btnSubmit.TabIndex = 0;
            this.btnSubmit.Text = "Joke Time!";
            this.btnSubmit.UseVisualStyleBackColor = true;
            this.btnSubmit.Click += new System.EventHandler(this.btnSubmit_Click);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(150, 9);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(182, 13);
            this.label1.TabIndex = 1;
            this.label1.Text = "How many dad jokes would you like?";
            // 
            // lblJokes
            // 
            this.lblJokes.AutoSize = true;
            this.lblJokes.Location = new System.Drawing.Point(12, 114);
            this.lblJokes.Name = "lblJokes";
            this.lblJokes.Size = new System.Drawing.Size(0, 13);
            this.lblJokes.TabIndex = 2;
            // 
            // cbNum
            // 
            this.cbNum.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cbNum.FormattingEnabled = true;
            this.cbNum.Items.AddRange(new object[] {
            "0",
            "1",
            "2",
            "3",
            "4",
            "5"});
            this.cbNum.Location = new System.Drawing.Point(178, 25);
            this.cbNum.Name = "cbNum";
            this.cbNum.Size = new System.Drawing.Size(121, 21);
            this.cbNum.TabIndex = 3;
            this.cbNum.SelectedIndexChanged += new System.EventHandler(this.cbNum_SelectedIndexChanged);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(500, 261);
            this.Controls.Add(this.cbNum);
            this.Controls.Add(this.lblJokes);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.btnSubmit);
            this.Name = "Form1";
            this.Text = "XML Dad Joke Reader";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button btnSubmit;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label lblJokes;
        private System.Windows.Forms.ComboBox cbNum;
    }
}

