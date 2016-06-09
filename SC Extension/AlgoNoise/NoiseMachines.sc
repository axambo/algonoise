NoiseMachines {
	var <>server;
	classvar <>bufdubsteprhythm, bufdubsteplead, buftechnorhythm, buftechnolead, buftechnovoice, bufbass, bufdancerhythm, bufinterference, bufdrumandbassrhythm, bufbutton, bufexperimentalrhythm, bufglitch;
	classvar <>dubsteprhythms, dubstepleads, technorhythms, technoleads, technovoices, dancerhythms, interferences, basses, drumandbassrhythms, buttons, experimentalrhythms, glitches;
	classvar <>path;
	classvar <>date;
	classvar <>file;
	classvar <>effects;

	*new {arg filepath = "/Users/annaxambo/Sounds/AlgoNoise";
		^super.new.init(filepath);
	}

	init {arg filepath;
		this.server = Server.local;
		Server.default = this.server;
		this.server.boot;
		path = filepath;

		//Sound samples for each instrument and section. Sounds can be added or replaced, and the algorithm will select them randomly from what is available.

		dubsteprhythms = ["130495__dirtyjewbs__dubstep-loop-epic-140bpm.wav", "118631__ongitak__b3-dubstep-loops-6-drums-stem.wav", "137224__dirtyjewbs__dubstep-drumloop-crunch-140bpm.wav",	"152947__dirtyjewbs__minimal-glitch-dubstep-beat-140.wav", "200852__looppacks__dubstep5.wav", "178906__ottorecv8__140-dubstep-loop-5.wav", "178904__ottorecv8__140-dubstep-loop-2.wav", "178903__ottorecv8__140-dubstep-loop-3.wav", "127338__mojomills__crushedrums-140.wav"];

		dubstepleads = ["223098__shainexedubstep__dubstep-snare.wav", "128236__ongitak__b7-dubstep-loops-3_p1.wav", "128236__ongitak__b7-dubstep-loops-3_p2.wav","184698__ottorecv8__dubstep-growl-like-skrillex.wav", "235417__oceanictrancer__140-bpm-noise-thing.wav", "222460__oceanictrancer__dubstep-lead-saw.wav", "124406__jobro__spring-theory_p1.wav", "124406__jobro__spring-theory_p2.wav", "124406__jobro__spring-theory_p3.wav", "124406__jobro__spring-theory_p4.wav"];

		technorhythms = ["106799__mikobuntu__electro-swing-140.wav", "124692__mikobuntu__tek-glitch.wav", "107558__mikobuntu__tekkno.wav", "5145__jovica__attack-loop-140-bpm-31.wav", "23570__djduppy__duppyhouse05-140bpm.wav"];

		technoleads = ["159393__dirtyjewbs__8-bit-harmony-140.wav", "94275__sirmxe__sivdin-bass-harmony-140-bpm.wav", "16173__harri__digibass-loop-140bpm.wav", "251006__onlytheghosts__badbabdabb-super-loop-140bpm-by-onlytheghosts.wav", "251438__onlytheghosts__keepemmoving-gumboots-loop-140bpm-by-onlytheghosts.wav"];

		technovoices = ["177263__sergeeo__french-abc.wav", "69247__reinsamba__alphabet-german-male.wav", "177269__sergeeo__numbers-in-french.wav", "255772__kwahmah-02__e17z_p1.wav", "255772__kwahmah-02__e17z_p2.wav", "52786__dobroide__japanese-numbers.wav", "69250__reinsamba__numbers-german-male.wav", "69168__corsica-s__50.wav", "102536__sandyrb__computer-numbers.wav", "21916__jppi-stu__numbers-for-free_p1.wav", "21916__jppi-stu__numbers-for-free_p2.wav", "21916__jppi-stu__numbers-for-free_p3.wav", "21916__jppi-stu__numbers-for-free_p4.wav", "257735__renjility__female-android-numbers-edit.wav", "275605__kb7clx__tuning-faux-numbers-station_p1.wav", "275605__kb7clx__tuning-faux-numbers-station_p2.wav", "177270__sergeeo__numbers-in-spanish.wav"];

		dancerhythms = ["30198__johnnypanic__rock140bpm.wav", "339117__sss-samples__break-beat-drum-loop-140-bpm.wav", "43587__oscillator__breakbeatep-allc-140bpm.wav", "106796__mikobuntu__140dubbreak.wav"];

		interferences = ["255772__kwahmah-02__e17z_interferences.wav", "275605__kb7clx__tuning-faux-numbers-station_interferences_p1.wav", "275605__kb7clx__tuning-faux-numbers-station_interferences_p2.wav", "170150__timgormly__interference1.wav", "46438__noisecollector__interference_p1.wav", "46438__noisecollector__interference_p2.wav", "190485__trip-sound__interferencesonicscape.wav", "123374__thatjeffcarter__electro-magnetic-interference.wav", "337747__quetzalcontla__radio-interference.wav"];

		basses = ["239514__luckylittleraven__sub-bass-wobble-slide-e1.wav", "251438__onlytheghosts__keepemmoving-gumboots-loop-140bpm-by-onlytheghosts.wav", "190565__goup-1__growl-bass.wav", "50848__m-red__wavebaseloop.wav", "58563__levite-sound__squarebass.wav", "166648__day-tripper13__hh140-bass-groove.wav"];

		effects = ["delay", "vibrato", "flanging", "phasing"];

		buttons = ["202128__lpspurplelps__phone-dialing.wav", "23536__percy-duke__pressing-phone-buttons.wav", "29950__herbertboland__bakelitephonedialing.wav", "137044__shotgunpicker__telephone-bakelite-w55-dialing.wav", "144120__avakas__keyboard-typing.wav", "158057__eelke__keyboard-typing-old.wav"];

		drumandbassrhythms = ["130495__dirtyjewbs__dubstep-loop-epic-140bpm_p1.wav", "130495__dirtyjewbs__dubstep-loop-epic-140bpm_p2.wav", "338957__sergio-c__urban-beat-loop-140.wav", "249681__unfa__drum-bass-synth-drum-loop-160-bpm.wav", "103043__mikobuntu__glitchedout2.wav", "31899__bloomypetal__add-a-little-bass-wav-beat.wav"];

		experimentalrhythms = ["23526__djduppy__commoditize-140bpm.wav", "244793__jalastram__experimental-drums-03.wav", "129159__dirtyjewbs__glitch-drumloop-95bpm.wav", "147525__dirtyjewbs__glitch-crushed-drums-140bpm.wav", "114031__dirtyjewbs__glitch-loop.wav", "102141__mikobuntu__glitchbeat5.wav"];

		glitches = ["171393__laspaziale__video-codec-audio-glitches_p1.wav", "171393__laspaziale__video-codec-audio-glitches_p2.wav", "171393__laspaziale__video-codec-audio-glitches_p3.wav", "171393__laspaziale__video-codec-audio-glitches_p4.wav", "171393__laspaziale__video-codec-audio-glitches_p5.wav", "171393__laspaziale__video-codec-audio-glitches_p6.wav", "171393__laspaziale__video-codec-audio-glitches_p7.wav", "171393__laspaziale__video-codec-audio-glitches_p8.wav"];

		CmdPeriod.add({this.cmdPeriod});

		server.waitForBoot {

			server.recSampleFormat = "int16";
			server.recChannels = 1;
			server.recHeaderFormat = "WAV";
			date = Date.getDate;
			file = File(path +/+ "output" +/+ date.stamp ++ "_credits" ++ ".txt","w");

			bufdubsteprhythm = Buffer.read(server, path +/+ "input" +/+ dubsteprhythms.choose);
			bufdubsteplead = Buffer.read(server, path +/+ "input" +/+ dubstepleads.choose);
			buftechnorhythm = Buffer.read(server, path +/+ "input" +/+ technorhythms.choose);
			buftechnolead = Buffer.read(server, path +/+ "input" +/+ technoleads.choose);
			buftechnovoice = Buffer.read(server, path +/+ "input" +/+ technovoices.choose);
			bufdancerhythm = Buffer.read(server, path +/+ "input" +/+ dancerhythms.choose);
			bufinterference = Buffer.read(server, path +/+ "input" +/+ interferences.choose);
			bufbass= Buffer.read(server, path +/+ "input" +/+ basses.choose);
			bufdrumandbassrhythm= Buffer.read(server, path +/+ "input" +/+ drumandbassrhythms.choose);
			bufbutton= Buffer.read(server, path +/+ "input" +/+ buttons.choose);
			bufexperimentalrhythm= Buffer.read(server, path +/+ "input" +/+ experimentalrhythms.choose);
			bufglitch = Buffer.read(server, path +/+ "input" +/+ glitches.choose);

			//recording audio

			server.prepareForRecord(path +/+ "output" +/+ date.stamp ++ "_song" ++ ".wav");

			//storing names of selected sound samples

			file.write("Sound samples used:\n");
			file.write(bufdubsteprhythm.path+"\n");
			file.write(bufdubsteplead.path+"\n");
			file.write(buftechnorhythm.path+"\n");
			file.write(buftechnolead.path+"\n");
			file.write(buftechnovoice.path+"\n");
			file.write(bufdancerhythm.path+"\n");
			file.write(bufinterference.path+"\n");
			file.write(bufbass.path+"\n");
			file.write(bufdrumandbassrhythm.path+"\n");
			file.write(bufbutton.path+"\n");
			file.write(bufexperimentalrhythm.path+"\n");
			file.write(bufglitch.path+"\n");

			//synthdefs: sounds

			SynthDef(\playbuf, {| bus = 0, buf = 0, rate = 1, loopMode = 1, amp = 1 |
				Out.ar(bus,
					PlayBuf.ar(2, buf, rate, doneAction:2, loop: loopMode) * amp
				)
			}).send(server);

			SynthDef(\randbgnoise, {| amp = 0.1, bus = 0 |
				var unitGens = [SinOsc, PinkNoise];
				var unitGen = unitGens.choose;
				var freq = Array.fill(2, { exprand(0.1, 0.4) });
				var signal = unitGen.ar(freq[0]);
				var signal2 = unitGen.ar(freq[1]);
				var randOps = [rrand(signal, signal2), linrand(signal, signal2), bilinrand(signal, signal2), sum3rand(signal, signal2), coin(signal, signal2)];
				var randOp = randOps.choose;
				var output = randOp;
				Out.ar(bus, output * amp ! 2)
			}).send(server);

			SynthDef(\impulserate, {| bus = 0, rate = 1, sustain = 1, vol = 0.5|
				var sig = Ringz.ar(Impulse.ar(rate, 0, vol), 50, 0.5) * EnvGen.kr(Env.perc(1, sustain), doneAction: 2);
				Out.ar(bus, sig ! 2)
			}).send(server);

			SynthDef(\phone, {|bus = 0, freq = 40, number=0, t_trig=0|
				var onoff, trigs, output;
				number = if(number < 0.5, 10, number); // zero = 10 clicks
				onoff = Trig1.ar(t_trig, number * 0.1);
				trigs = LPF.ar(Impulse.ar(10), freq) * onoff;
				output = Trig1.ar(trigs, 0.04);
				Out.ar(bus, output * 0.4 ! 2);
			}).send(server);

			SynthDef(\basicdrone, {|freq = 50, amp = 0.5|
				var output = RLPF.ar(CrossoverDistortion.ar(SinOsc.ar(freq), 1)) * amp;
				Out.ar(0, output ! 2)
			}).send(server);

			//synthdefs: FXs
			SynthDef(\delay, {| ibus = 0, bus = 0, delaytime = 0.2 |
				var input, effect;
				input = In.ar(ibus, 2); //get two channels of input starting (and ending) on bus (0 by default)
				effect = DelayN.ar(input, 1, delaytime); //max delay of one second
				Out.ar(bus, effect);
			}).send(server);


			SynthDef(\vibrato, {| ibus = 0, bus = 0 |
				var input, effect;
				input = In.ar(ibus, 2); //get two channels of input starting (and ending) on bus (0 by default)
				effect = DelayC.ar(input, 0.01, SinOsc.ar(Rand(5,10),0,0.0025,0.0075)); //max delay of 10msed
				Out.ar(bus, effect);
			}).send(server);

			SynthDef(\flanging, {| ibus = 0, bus = 0, fdback=0.1, flangefreq=0.1 |
				var input, effect;
				input = In.ar(ibus, 2); //get two channels of input starting (and ending) on bus (0 by default)
				input = input+ LocalIn.ar(2); //add some feedback
				effect = DelayN.ar(input,0.02,SinOsc.kr(flangefreq,0,0.005,0.005)); //max delay of 20msec
				LocalOut.ar(fdback*effect);
				Out.ar(bus,effect);
			}).send(server);


			SynthDef(\phasing, {| ibus = 0, bus = 0, freq=0.2 |
				var input, effect;
				input = In.ar(ibus, 2); //get two channels of input starting (and ending) on bus (0 by default)
				effect = AllpassN.ar(input,0.02,SinOsc.kr(freq,0,0.01,0.01)); //max delay of 20msec
				Out.ar(bus, effect);
			}).send(server);

		};

	}

	playsong {

		var rhythm1, noise1, lead1, effect1, bass1;
		var rhythm2, noise2, lead2, effect2, bass2;
		var voice1, buttons1, drone1, glitch1;
		var routine1, routine2;
		var a = Group.basicNew(server,1);

		server.record;

		routine1 = Routine({
			var delta, rate1;
			loop {
				delta = rrand(1, 4) * 0.25;
				rate1 = rrand(0.1,1) * 10;
				Synth(\impulserate, [rate: rate1, vol: rrand(0.1,0.5), sustain: delta * 0.8]);
				delta.yield;
			}
		});

		routine2 = Routine({
			rrand(16,32).do {
				Synth(\phone).set(\t_trig, 1, \number, 10.rand);
				rrand(0.2,0.6).wait;
				1.0.wait;
			};
		});

		// structure of the session

		// zone 1, A (intro)
		AppClock.sched(0.0,{//0min
			server.bind {
				rhythm1 = Synth(\playbuf,[\buf,bufdubsteprhythm.bufnum]);
				noise1 = Synth(\randbgnoise);
				lead1 = Synth.head(a, \playbuf, [\buf,bufdubsteplead.bufnum, \amp, 0.5]);
			};
		});
		// zone 1, B (FXs)
		AppClock.sched(60.0,{//1min
			server.bind{
				rhythm1.set(\rate,[2.0, 0.5, -1.0].choose);
				noise1.set(\amp,[0.1,0.2,0.3].choose);
				//lead1:1
			}
		});
		// zone 1, A
		AppClock.sched(90.0,{//1min30sec
			server.bind{
				rhythm1.set(\rate,1);
				noise1.set(\amp,0.1);
				lead1.set(\bus,10,\rate,[2.0, 0.5, -1.0].choose);
				effect1 = Synth.tail(a, effects.choose,[\ibus,10,\bus,0]);
			}
		});
		// zone 1, B (FXs)
		AppClock.sched(150.0,{//2min30sec
			server.bind{
				lead1.free;
				rhythm1.set(\rate,[2.0, 1.0, 0.5, -1.0].choose);
				noise1.set(\amp,0.1);
				//noise1:1
			}
		});

		AppClock.sched(155.0,{//2min35sec
			server.bind{
				//rhythm1.set(\rate,1);
				noise1.set(\amp,[0.1,0.2,0.3].choose,\bus,10);
				effect1 = Synth.tail(a, effects.choose,[\ibus,10,\bus,0]);
				rhythm1.set(\bus,0);
				//rhythm1:1, lead1: 0
			}
		});

		// zone 1 -> zone 2 (transition)
		AppClock.sched(165.0,{//2min45sec
			server.bind {
				effect1.free;
				rhythm2 = Synth(\playbuf,[\buf,buftechnorhythm.bufnum]);
				rhythm1.set(\bus, 0);
				//lead1: 0
				noise1.set(\bus, 0);
				//rhythm1:1, lead1: 0, noise1:1(w/FX)
			};
		});

		// zone 2, A
		AppClock.sched(180.0,{//3min
			server.bind {
				noise1.free;
				rhythm1.free;
				//lead1: 0, rhythm2:1
				lead2 = Synth(\playbuf,[\buf,buftechnolead.bufnum,\amp,0.6]);
			};
		});

		//zone 2, A'
		AppClock.sched(210.0,{//3min30sec
			server.bind {
				voice1 = Synth.head(a,\playbuf,[\buf,buftechnovoice.bufnum]);
				//lead2:1, rhythm2:1
			};
		});

		//zone 2, A
		AppClock.sched(240.0,{//4min
			server.bind{
				rhythm2.set(\amp, 0);
				routine1.play;
				lead2.set(\amp, 0.8);
				//lead2:1, voice1:1
			}
		});

		//zone 2, B (FXs)
		AppClock.sched(270.0,{//4min30sec
			server.bind{
				voice1.set(\bus,10);
				effect1 = Synth.tail(a, effects.choose, [\ibus,10,\bus,0]);
				lead2.set(\bus,0, \amp, 1);
				rhythm2.set(\amp,0.8,\bus,0);
				routine2.play;
				//routine1.play;
				//lead2:1, routine1:1
			}
		});


		//zone 2 -> zone 3 (transition)
		AppClock.sched(300.0,{//5min
			server.bind{
				effect1.free;
				voice1.free;
				lead2.free;
				routine1.stop;
				rhythm1 = Synth(\playbuf, [\buf,bufdancerhythm.bufnum]);
				rhythm2.set(\amp,0.6);
			}
		});

		AppClock.sched(310.0,{//5min10sec
			server.bind{
				rhythm2.set(\amp,0.3);
			}
		});

		AppClock.sched(320.0,{//5min20sec
			server.bind{
				rhythm2.set(\amp,0.1);
			}
		});

		//zone 3, A
		AppClock.sched(330.0,{//5min30sec
			server.bind{
				rhythm2.free;
				routine2.stop;
				noise1 =  Synth(\playbuf,[\buf,bufinterference.bufnum, \rate,[2.0, 0.5, -1.0].choose]);
				//rhtyhm1:1
			}
		});

		//zone 3, A'
		AppClock.sched(390.0,{//6min30sec
			server.bind{
				rhythm1.set(\rate, [2.0, 1.0, 0.5, -1.0].choose);
				noise1.set(\rate, 1);
				//rhythm1:1
			}
		});


		//zone 3, A
		AppClock.sched(420.0,{//7min
			server.bind{
				noise1.set(\rate, [2.0, 0.5, -1.0].choose);
				noise2 = Synth(\playbuf,[\buf,bufinterference.bufnum, \rate,[2.0, 0.5, -1.0].choose]);
			}
		});

		//zone 3, B (FXs)
		AppClock.sched(450.0,{//7min30sec
			server.bind{
				noise1.set(\bus,10,\rate,[2.0, 1.0, 0.5, -1.0].choose);
				noise2.set(\bus,10,\rate,[2.0, 1.0, 0.5, -1.0].choose);
				effect1 = Synth.tail(a, effects.choose,[\ibus,10,\bus,0]);
				bass1 = Synth(\playbuf,[\buf,bufbass.bufnum,\bus,0]);
				rhythm1.set(\rate,1,\bus,0);
			}
		});

		//zone 3, B'
		AppClock.sched(480.0,{//8min
			server.bind{
				//rhythm1:1, noise1:1, bass1:1
				effect1.free;
				//rhythm1.set(\bus, 0);
				noise1.set(\bus, 0, \rate, [2.0, 1.0, 0.5, -1.0].choose);
				noise2.set(\bus, 0, \rate, [2.0, 1.0, 0.5, -1.0].choose);
			}
		});

		// zone 3 -> zone 4 (long transition)
		AppClock.sched(510.0,{//8min30sec
			server.bind{
				//noise1:1, noise2:1, bass1:1
				rhythm1.free;
			}
		});

		AppClock.sched(540.0,{//9min
			server.bind{
				//noise1:1, noise2:1, bass1:1
				rhythm2 = Synth(\playbuf,[\buf,bufdrumandbassrhythm.bufnum]);
				voice1 = Synth(\playbuf,[\buf,buftechnovoice.bufnum,\amp,1,\rate,[1.0,-1.0].choose]);
			}
		});

		AppClock.sched(570.0,{//9min30sec
			server.bind{
				//noise1:1, noise2:1, rhythm2:1, voice1:1, bass1:1
				bass2 = Synth(\playbuf,[\buf,bufbass.bufnum,\rate,[0.5, -1.0].choose]);
			}
		});

		AppClock.sched(600.0,{//10min
			server.bind{
				voice1.free;
			}
		});

		//zone 4, A
		AppClock.sched(630.0,{//10min30sec
			server.bind{
			    noise1.free;
			    rhythm2.free;
				bass1.free;
			    //bass2:1, noise2:1;
				drone1 = Synth(\basicdrone,[\freq,rrand(40,60),\amp, rrand(0.05,0.3)]);

			}
		});

		//zone 4, A'
		AppClock.sched(660.0,{//11min
			server.bind{
		        //bass2:1, drone1:1, noise2:1
				buttons1 = Synth(\playbuf,[\buf,bufbutton.bufnum,\rate,[2.0, 0.5, -1.0].choose]);

			}
		});

		//zone 4, A
		AppClock.sched(690.0,{//11min30sec
			server.bind{
		        //drone1:1, buttons1:1
				bass2.free;
				noise2.free;
				rhythm1 = Synth(\playbuf,[\buf,bufexperimentalrhythm.bufnum]);
			}
		});

		//zone 4, A'
		AppClock.sched(750.0,{//12min30sec
			server.bind{
		        //drone1:1, buttons1:1, rhythm1:1
			    buttons1.set(\rate,[2.0, 0.5, -1.0].choose);
				rhythm2 = Synth(\playbuf,[\buf, bufexperimentalrhythm.bufnum,\rate,-1.0]);
			}
		});

		//zone 4, A
		AppClock.sched(810.0,{//13min30sec
			server.bind{
			    buttons1.free;
				rhythm1.free;
				drone1.free;
				glitch1 = Synth.tail(a, \playbuf, [\buf, bufglitch.bufnum,\rate,[1.0, 0.5, 2.0,-1.0].choose, \amp, 0.7]);
			}
		});

		//zone 4, B (FXs)
		AppClock.sched(840.0,{//14min
			server.bind{
				glitch1.set(\bus,10);
				effect1 = Synth.tail(a, effects.choose, [\ibus,10,\bus,0]);
			}
		});

		//zone 4, B' (FXs)
		AppClock.sched(870.0,{//14min30sec
			server.bind{
				//glitch1:1
				rhythm2.set(\bus,10);
			}
		});

		//end
		AppClock.sched(900.0,{//15min
			server.bind{
				effect1.free;
				rhythm2.free;
				glitch1.free;
			}
		});

		AppClock.sched(901.0,{
			server.stopRecording;
			file.close;
		});

	}

	cmdPeriod {
		file.close;
		currentEnvironment.clear;
	}

}