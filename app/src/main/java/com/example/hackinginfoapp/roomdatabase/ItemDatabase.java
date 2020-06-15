package com.example.hackinginfoapp.roomdatabase;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Item.class}, version = 2)
public abstract class ItemDatabase extends RoomDatabase {

    private static ItemDatabase instance;

    public abstract ItemDao itemDao();

    public static synchronized ItemDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    ItemDatabase.class, "item_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private ItemDao itemDao;

        private PopulateDbAsyncTask(ItemDatabase db) {
            itemDao = db.itemDao();
        }

        /*Database entries*/
        /* itemDao.insert(new Item("", "", "", "")); */
        @Override
        protected Void doInBackground(Void... voids) {

            /*Cyber-vulnerabilities entries*/
            itemDao.insert(new Item("Injection", "Injection flaws, such as SQL, NoSQL, OS, and LDAP injection, occur when untrusted data is sent to an interpreter as part of a command or query. \n" +
                    "The attacker’s hostile data can trick the interpreter into executing unintended commands or accessing data without proper authorization",
                    "injection", "cybervuls"));
            itemDao.insert(new Item("Broken Authentication", "Application functions related to authentication and session management are often implemented incorrectly.\n" +
                    "This allows attackers to compromise passwords, keys, or session tokens, or to exploit other implementation flaws to assume other users’ identities temporarily or permanently.",
                    "brokenauth", "cybervuls"));
            itemDao.insert(new Item("Sensitive Data Exposure", "Many web applications and APIs do not properly protect sensitive data, such as financial, healthcare, and PII. \n" +
                    "Attackers may steal or modify such weakly protected data to conduct credit card fraud, identity theft, or other crimes. \n" +
                    "Sensitive data may be compromised without extra protection, such as encryption at rest or in transit, and requires special precautions when exchanged with the browser.\n",
                    "sensitivedataexposure", "cybervuls"));
            itemDao.insert(new Item("XML External Entities", "Many older or poorly configured XML processors evaluate external entity references within XML documents. \n" +
                    "External entities can be used to disclose internal files using the file URI handler, internal file shares, internal port scanning, remote code execution, and denial of service attacks.\n",
                    "xmlextent", "cybervuls"));
            itemDao.insert(new Item("Broken Access Control", "Restrictions on what authenticated users are allowed to do are often not properly enforced. \n" +
                    "Attackers can exploit these flaws to access unauthorized functionality and/or data, such as access other users' accounts, view sensitive files, modify other users’ data, change access rights, etc.\n",
                    "brokenaccesscontrol", "cybervuls"));
            itemDao.insert(new Item("Security Misconfiguration", "Security misconfiguration is the most commonly seen issue. This is commonly a result of insecure default configurations, incomplete or ad hoc configurations, open cloud storage, misconfigured HTTP headers, and verbose error messages containing sensitive information. \n" +
                    "Not only must all operating systems, frameworks, libraries, and applications be securely configured, but they must be patched and upgraded in a timely fashion.\n",
                    "securitymisconfig", "cybervuls"));
            itemDao.insert(new Item("Cross-site Scripting", "XSS flaws occur whenever an application includes untrusted data in a new web page without proper validation or escaping, or updates an existing web page with user-supplied data using a browser API that can create HTML or JavaScript. \n" +
                    "XSS allows attackers to execute scripts in the victim’s browser which can hijack user sessions, deface web sites, or redirect the user to malicious sites.\n",
                    "crosssitescripting", "cybervuls"));
            itemDao.insert(new Item("Insecure Deserialization", "Insecure deserialization often leads to remote code execution. \n" +
                    "Even if deserialization flaws do not result in remote code execution, they can be used to perform attacks, including replay attacks, injection attacks, and privilege escalation attacks. \n",
                    "insecuredesil", "cybervuls"));
            itemDao.insert(new Item("Using Components with known vulnerabilities", "Components, such as libraries, frameworks, and other software modules, run with the same privileges as the application. If a vulnerable component is exploited, such an attack can facilitate serious data loss or server takeover. \n" +
                    "Applications and APIs using components with known vulnerabilities may undermine application defenses and enable various attacks and impacts\n",
                    "compwithknownvul", "cybervuls"));
            itemDao.insert(new Item("Insufficient logging and monitoring", "Insufficient logging and monitoring, coupled with missing or ineffective integration with incident response, allows attackers to further attack systems, maintain persistence, pivot to more systems, and tamper, extract, or destroy data. \n" +
                    "Most breach studies show time to detect a breach is over 200 days, typically detected by external parties rather than internal processes or monitoring.\n",
                    "insufflogmon", "cybervuls"));



            /*Famous Hackers entries*/
            itemDao.insert(new Item("Kevin Mitnick", "Named by the US Department of Justice the most wanted computer criminal in history, Kevin Mitnick served a year in prison for hacking into the Digital Equipment Corporation's network. \n" +
                    "Kevin was released from jail to be put under supervised release. Instead Kevin fled and went on an almost 3 year hacking-spree. On his spree he breached the national defense warning system and stole many corporate secrets. \n " +
                    "Eventually Kevin was caught and sentenced to five years in prison. After this he went on to become a computer security consultant and public speaker with his own security company.",
                    "kevinmitnick", "famoushackers"));
            itemDao.insert(new Item("Jonathan James", "Jonathan had been hacking from a young age, managing to hack into many governmental and commercial networks. He was sent to prison for this while he was still a minor. \n" +
                    "He eventually hacked into NASA's and downloaded source code from their network that equalled $1.7m at the time. This included code for the International Space Station. This resulted in NASA having to shut its network down for three weeks while they investigated. \n" +
                    "In 2007 Jonathan James was accused of hacking several other high-profile companies. He denied any involvement but later committed suicide because he believed he would be convicted for the crimes.",
                    "jonathanjames", "famoushackers"));
            itemDao.insert(new Item("Albert Gonzalez", "Albert was the leader of the 'ShadowCrew' hacking group. He started off his career in cybercrime by stealing and selling credit card numbers, fabricating fraudulent passports, health insureance cards and birth certificates for identity theft. \n" +
                    "Albert's biggest hack involved hacking into the databases of TJX Companies and Heartland Payment Systems to steal all of their credit card numbers. He stole more than $170m worth of credit card and ATM card numbers. \n" +
                    "He was later sentenced to prison for 20 years and is set to be released in 2025.",
                    "albertgonzalez", "famoushackers"));
            itemDao.insert(new Item("Kevin Poulsen", "Kevin Poulsen went by the hacker alias of 'Dark Dante'. A phreaker from California, he hacked into a radio station's phone lines and managed to fix himself as the winner of a phone-in competition for a brand-new Porsche. \n" +
                    "He became known to the FBI when he stole wiretap information by hacking into federal systems. He was captured while out shopping at a supermarket and sentenced to 51 months in prison and ordered to pay $56,000 in restitution money. \n" +
                    "After being released from prison in 1995 Paul changed his focus to journalism and now is a contributing editor for Wired.",
                    "kevinpoulsen", "famoushackers"));
            itemDao.insert(new Item("Gary McKinnon", "Another hacker who hacked into NASA, Gary McKinnon (known by his hacker alias as 'Solo') hacked into 97 US Armed Forces and NASA computers over a period of 13-months. \n" +
                    "He claimed he was looking for information regarding coverups of UFOs and free-energy suppression. He was able to evade the US government until 2005 when he faced extradition, as he was Scottish and living in the United Kingdom. \n",
                    "garymckinnon", "famoushackers"));
            itemDao.insert(new Item("Robert Tappan Morris", "Robert Tappan Morris is credited with the creation of the world's very first computer worm. He learned much of his computer expertise from his father, who was a computer scientist at Bell Labs and NASA. \n" +
                    "While he was as student at Cornell University in 1988 he created a computer worm which was intended to help him gauge the size of the internet. However, the worm had a fatal flaw in that it would constantly replicate itself on computers, rendering them inoperable. \n" +
                    "He was sentenced to three years probation, 400 hours of community service and a $10,500 fine after being found to have violated the Computer Fraud and Abuse act. He now works as a professor at the Massachusetts Institute of Technology.",
                    "roberttappanmorris", "famoushackers"));
            itemDao.insert(new Item("Lloyd Blankenship", "Lloyd Blankenship, known by his alias of 'The Mentor' amongst the hacking community, was a member of many different hacking groups, the most prominent of which being 'Legion of Doom'. \n" +
                    "Blankenship wrote a manifesto called 'Mentor's Last Words' in 1986 before he was arrested. The manifesto came to be seen as a cornerstone of culture amongst the hacking community. Blankenship now works for McAfee as the head of product research and design.",
                    "lloydblankenship", "famoushackers"));
            itemDao.insert(new Item("Guccifer 2.0", "No one knows who the person, or people, behind Guccifer 2.0 are. The name 'Guccifer' originates from that of a Romanian hacker who was known for targetting US government officials and political figures. \n" +
                    "In 2016 Guccifer 2.0 hacked into the Democratic National Convention's network and leaked thousands of documents onto the web. As this was just before the US Presidential Election many believed that Guccifer 2.0 was in cahoots with Russian intelligence. \n" +
                    "In an interview with Vice however, Guccifer 2.0 claimed he was not Russian, but Romanian. He has not been heard of since claiming he had no ties to Russian intelligence.",
                    "guccifer", "famoushackers"));
            itemDao.insert(new Item("Anonymous", "Anonymous is arguably the world's most infamous group of hackers. Over the years they have been active in many hacks across the world. They are a decentralised international hacktivist group which focuses attacks mainly on governmental agencies, institutions, corporations and the Church of Scientology. \n" +
                    "Anonymous originated on the internet imageboard 4chan. They are well known for wearing Guy Fawkes masks as seen in the movie V for Vendetta and for making post-hack videos addressing governments using voice-changers to conceal their identity. \n" +
                    "They were responsible for hacks on the United Nations, ISIS, the KKK, amongst many others. Some liken them to 'Digital Robin Hoods' while others refer to them as cyber-criminals and cyber-terrorists.",
                    "anonymous", "famoushackers"));

            /*Famous Hacks entries*/
            itemDao.insert(new Item("The Ashley Madison Hack", "For those of you who don't know, Ashley Madison is a website catered to people in a serious relationship or marriage who are looking to find an affair. \n" +
                    "In July 2015 the hacker group 'Impact Team' hacked into the servers of Ashley Madison's parent company 'Avid Life Media' and stole the data of 37 million users. Following this the hackers then released all of the private data onto the open web for all to see. \n" +
                    "This hack was responsible for ruining the marriages and reputations of many of the website's users who wished to keep their secrets under wraps. This hack was a publicity nightmare for the Ashley Madison website and shows how devastating server breaches and private data leaks can be.",
                    "ashleymadison", "famoushacks"));
            itemDao.insert(new Item("Stuxnet", "Stuxnet is probably one of the scariest hacks out there, not because of what happened, but because of what could of happened. \n" +
                    "Stuxnet was a computer worm that was uncovered in 2010. It was thought to have been in development since 2005. The target of the worm was the nuclear program of Iran. Its purpose was to target the PLCs (the programmable logic controllers present in many critical functions of machinery such as dams, manufacturing plants and nuclear power plants) \n" +
                    "of a Nuclear Power Plant in Iran and sabotage the process by which its gas centrifuges would separate nuclear material. The worm caused the centrifuges to tear themselves apart as they span, causing untold damage to Irans nuclear program. \n" +
                    "The nature of the Stuxnet worm's architecture meant that it could easily be retailored for use in many PLCs present in other areas. The worm infected over 200,000 computers and caused 1,000 machines to physically degrade. Once the worm had done its work it would cover its tracks using a rootkit so that it could not be detected afterward. ",
                    "stuxnet", "famoushacks"));
            itemDao.insert(new Item("Operation Darknet", "In 2011 hacktivist group Anonymous gained access to a hidden website on the dark net. The website was used by pedophiles to share child pornography. Called 'Lolita City' the website used hidden services available through the TOR network to remain hidden to anyone but a select few. " +
                    "The website hosted around 1.4 million pictures and videos had been available there since 2012. Anonymous gained access to the private records of users on the website. " +
                    "They then publicly shared the names of 1,589 members of the website on pastebin. In a video they made after the attack Anonymous claimed credit for the attack and said that the website had over 100 gigabytes of child pornography. " +
                    "This hack is significant because it goes to show that, although hacking is illegal, vigilante groups such as anonymous can sometimes be a benefit to society.",
                    "opdarknet", "famoushacks"));


            /*How to protect against Cyber Attacks entries*/
            itemDao.insert(new Item("Access Control", "Separation of duties\n" +
                    " - No single individual should be allowed to perform high-value or sensitive tasks on their own. \n" +
                    " - Example; Financial transactions, Software changes, User account creation / changes).\n" +
                    " - People should only have access to the functions / data that they require to perform their stated duties (i.e. Server applications don't run as root, don't give people access to other people's files, using User Account Control at workstations).",
                    "accesscontrol", "howtoprotect"));
            itemDao.insert(new Item("Multi-tiered defense systems", " - Use in-depth defense measures \n" +
                    " - i.e. use multiple controls to protect assets so if one type fails the other is still present\n" +
                    " - nested firewalls on workstations & file servers",
                    "defensesystem", "howtoprotect"));
            itemDao.insert(new Item("Use Detective Controls", " - Monitor and record specific types of events (e.g. users gaining new admin privileges) \n" +
                    " - This can include audit logs, event logs and commercially available intrusion detection systems \n" +
                    " - WORKING Video surveillance in important areas such as server rooms",
                    "detective", "howtoprotect"));
            itemDao.insert(new Item("Recovery Controls", " - Always have system and database restoration backups available in case your system becomes comprimised \n",
                    "backup", "howtoprotect"));

            return null;
        }
    }
}
