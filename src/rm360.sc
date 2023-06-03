;;; Sierra Script 1.0 - (do not remove this comment)
(script# 360)
(include sci.sh)
(use Main)
(use PalCycle)
(use EcoFeature)
(use EcoDialog)
(use Osc)
(use n958)
(use Sound)
(use Cycle)
(use Game)
(use User)
(use Obj)

(public
	rm360 0
)

(local
	theExecProducer
	theKen
	theJane
	theTheExecProducer
	theTheKen
	theTheJane
	local6
	[theIntLo 2] = [48 112]
	local9
	theTicks
	theTicks_2 =  14
	local12
	local13
	local14
	local15
	local16 =  1
	local17
	local18
	local19
	[local20 4]
)
(procedure (localproc_00bc)
	(global2 drawPic: 901 -32759)
)

(instance rm360 of Rm
	(properties)
	
	(method (init)
		(proc958_0 128 360 364 40 361 362 956 363 342 365)
		(proc958_0 129 360 50 901 320 340)
		(proc958_0 132 360 398 362)
		(= local6 0)
		(eco1
			init:
			posn: 133 73
			setLoop: 1
			cel: 0
			ignoreActors: 1
			hide:
		)
		(eco2
			init:
			posn: 164 62
			setLoop: 0
			ignoreActors: 1
			cel: 0
			hide:
		)
		(super init: &rest)
		(SetCursor 957 0 9)
		(self setScript: main0)
	)
	
	(method (doit &tmp [temp0 60] [temp60 20] [temp80 20] [temp100 20])
		(super doit:)
		(if (== (self curPic?) 340)
			(Palette palANIMATE 160 207 1)
		)
		(if (== ((User curEvent?) message?) 15360) (return 0))
		(if (proc999_5 ((User curEvent?) type?) 1 4 256)
			(= local19 1)
		)
		(return
			(if local19
				(Message msgGET 360 1 0 0 1 @temp0)
				(Message msgGET 360 1 0 0 2 @temp60)
				(Message msgGET 360 1 0 0 3 @temp80)
				(Message msgGET 360 1 0 0 4 @temp100)
				(Sound pause: 1)
				(gGame setCursor: gWaitC)
				(SetCursor 58 110)
				(switch
					(proc821_1
						@temp0
						79
						813
						0
						0
						64
						-1
						60
						109
						78
						@temp60
						2
						109
						78
						@temp80
						0
						109
						78
						@temp100
						1
					)
					(0
						(Sound pause: 0)
						(SetCursor 957 0 9)
					)
					(1
						(Sound pause: 0)
						(gGame restore:)
					)
					(2
						(Sound pause: 0)
						(if (IsObject bubbles) (bubbles setScript: 0 hide:))
						(self setScript: leave)
					)
				)
				(= local19 0)
				((User curEvent?) type: 0)
			else
				0
			)
		)
	)
	
	(method (dispose)
		(super dispose: &rest)
	)
)

(instance leave of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(gCast eachElementDo: #hide)
				(gLongSong fade: 0 10 4 1)
				(= cycles (= cycles 1))
			)
			(1
				(Palette palSET_INTENSITY 0 255 0)
				(global2 drawPic: 901 9)
				(= cycles (= cycles 4))
			)
			(2
				(self dispose:)
				(= cycles (= cycles 4))
				(global2 newRoom: 400)
			)
		)
	)
)

(instance bubbleStuff of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(= local13 0)
				(= local9 (* (Random 1 10) 25))
				(gSoundEffects number: 362 loop: 1 play:)
				(bubbles
					startUpd:
					show:
					setCel: 0
					setLoop: 4
					moveSpeed: 4
					posn: local9 168
					setMotion: MoveTo local9 145 self
				)
			)
			(1
				(bubbles setCel: 1 setMotion: MoveTo local9 110 self)
			)
			(2
				(bubbles setCel: 2 setMotion: MoveTo local9 92 self)
			)
			(3
				(bubbles setCel: 3 setMotion: MoveTo local9 40 self)
			)
			(4
				(bubbles setCel: 4 setMotion: MoveTo local9 10 self)
			)
			(5
				(bubbles setCel: 5 setMotion: MoveTo local9 6 self)
			)
			(6
				(bubbles setCel: 6 setMotion: MoveTo local9 -50 self)
			)
			(7
				(= local13 1)
				(= seconds (= seconds 3))
			)
			(8 (self changeState: 0))
		)
	)
)

(instance ecoStuff of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(dolphin hide:)
				(eco1 show: posn: 133 74 setCycle: End)
				(eco2 show: posn: 164 62 setCycle: End self)
			)
			(1
				(eco1 setLoop: 3 cel: 0 setCycle: End)
				(eco2 setLoop: 2 cel: 0 setCycle: End self)
			)
			(2
				(= local6 0)
				(self dispose:)
			)
		)
	)
)

(instance main0 of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(cycleStuff
					cycleInt: 0
					numInt: 1
					cyclePal: 1
					oscInt: 1
					intDir: 3
					init:
					loIntLevel: 50
				)
				(global2 drawPic: 50 9)
				(= local6 1)
				(= cycles (= cycles 1))
			)
			(1
				(gLongSong number: 360 loop: -1 play:)
				(bubbles
					init:
					ignoreActors: 1
					ignoreHorizon: 1
					setLoop: 4
					setStep: 10 10
					moveSpeed: 2
					setScript: bubbleStuff
				)
				(= local6 2)
				(presents init: hide:)
				(an init: hide:)
				(under init: hide:)
				(adven init: hide:)
				(= ticks (= ticks 20))
			)
			(2
				(presents show: stopUpd:)
				(= ticks (= ticks 60))
			)
			(3
				(an show: stopUpd:)
				(= ticks (= ticks 30))
			)
			(4
				(under show: stopUpd:)
				(= ticks (= ticks 30))
			)
			(5
				(adven show: stopUpd:)
				(= ticks (= ticks 180))
			)
			(6
				(bubbles hide: setScript: 0)
				(= local13 1)
				(presents dispose:)
				(an dispose:)
				(under dispose:)
				(adven dispose:)
				(= cycles (= cycles 1))
			)
			(7
				(localproc_00bc)
				(= cycles (= cycles 1))
			)
			(8
				(cycleStuff cyclePal: 0 restorePal:)
				(= cycles (= cycles 1))
			)
			(9
				(localproc_00bc)
				(= cycles (= cycles 1))
			)
			(10 (global2 setScript: main1))
		)
	)
)

(instance main1 of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(= local6 0)
				(= theTicks 10)
				(cycleStuff savePal: cyclePal: 1)
				(global2 drawPic: 360 9)
				(= cycles (= cycles 1))
			)
			(1
				(dolphin
					init:
					ignoreActors: 1
					posn: 279 58
					setLoop: 0
					setCel: 0
				)
				(= ticks (= ticks theTicks))
			)
			(2
				(dolphin posn: 249 54 setLoop: 0 setCel: 1)
				(= ticks (= ticks theTicks))
			)
			(3
				(dolphin posn: 177 49 setLoop: 0 setCel: 2)
				(= ticks (= ticks theTicks))
			)
			(4
				(dolphin posn: 135 92 setLoop: 1 setCel: 0)
				(= ticks (= ticks theTicks))
			)
			(5
				(dolphin posn: 91 80 setLoop: 1 setCel: 1)
				(= ticks (= ticks theTicks))
			)
			(6
				(dolphin posn: 19 69 setLoop: 1 setCel: 2)
				(= ticks (= ticks theTicks))
			)
			(7
				(sfx play:)
				(bubbles setScript: bubbleStuff)
				(self setScript: ecoStuff)
				(cycleStuff cyclePal: 1)
				(= ticks (= ticks 420))
			)
			(8
				(eco1 hide:)
				(eco2 hide:)
				(bubbles hide: setScript: 0)
				(= cycles (= cycles 1))
			)
			(9
				(localproc_00bc)
				(= cycles (= cycles 1))
			)
			(10
				(cycleStuff cyclePal: 0 restorePal:)
				(= cycles (= cycles 1))
			)
			(11
				(localproc_00bc)
				(= cycles (= cycles 1))
			)
			(12
				(global2 setScript: main2)
				(bubbles setScript: 0)
			)
		)
	)
)

(instance main2 of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(= theExecProducer execProducer)
				(= theKen ken)
				(self setScript: oceanCredit self)
				(= theTheExecProducer theExecProducer)
				(= theTheKen theKen)
			)
			(1
				(= theExecProducer creatDirector)
				(= theKen billD)
				(self setScript: dolphinCredit self)
				(= theTheExecProducer theExecProducer)
				(= theTheKen theKen)
			)
			(2
				(bubbles setScript: 0 hide:)
				(= theExecProducer director)
				(= theKen billS)
				(self setScript: oceanCredit self)
				(= theTheExecProducer theExecProducer)
				(= theTheKen theKen)
			)
			(3
				(= theExecProducer producer)
				(= theKen tammy)
				(self setScript: dolphinCredit self)
				(= theTheExecProducer theExecProducer)
				(= theTheKen theKen)
			)
			(4
				(= theExecProducer gameDesign)
				(= theKen gano)
				(= theJane jane)
				(self setScript: dolphinCredit2 self)
				(= theTheExecProducer theExecProducer)
				(= theTheKen theKen)
				(= theTheJane theJane)
			)
			(5
				(= theExecProducer artDesign)
				(= theKen billS2)
				(self setScript: dolphinCredit3 self)
				(= theTheExecProducer theExecProducer)
				(= theTheKen theKen)
			)
			(6
				(= theExecProducer leadProgram)
				(= theKen jerry)
				(self setScript: dolphinCredit2 self)
				(= theTheExecProducer theExecProducer)
				(= theTheKen theKen)
			)
			(7
				(bubbles setScript: 0 hide:)
				(= theExecProducer composer)
				(= theKen chris)
				(self setScript: oceanCredit self)
				(= theTheExecProducer theExecProducer)
				(= theTheKen theKen)
			)
			(8
				(Load rsSOUND 361)
				(self setScript: dolphinNoCredit self)
			)
			(9
				(bubbles setScript: 0 hide:)
				(self setScript: oceanNoCredit self)
			)
			(10
				(self setScript: dolphinNet self)
			)
			(11
				(gGame setCursor: gWaitC)
				(gLongSong fade: 0 10 4 1)
				(self dispose:)
				(global2 newRoom: 400)
			)
		)
	)
)

(instance oceanCredit of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(Load rsSOUND 398)
				(if (IsObject theTheExecProducer)
					(theTheExecProducer dispose:)
				)
				(if (IsObject theTheKen) (theTheKen dispose:))
				(global2 drawPic: 321 9)
				(= cycles (= cycles 1))
			)
			(1
				(eco1 setScript: credit)
				(dolphin
					show:
					view: 361
					setLoop: 2
					setCel: 0
					posn: 157 82
					setCycle: CT 7 1 self
				)
			)
			(2
				(gSoundEffects number: 398 play:)
				(dolphin setCycle: End self)
			)
			(3
				(dolphin hide:)
				(= ticks (= ticks 180))
			)
			(4 (self dispose:))
		)
	)
)

(instance dolphinCredit of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(theTheExecProducer dispose:)
				(theTheKen dispose:)
				(global2 drawPic: 901 9)
				(= cycles (= cycles 1))
			)
			(1
				(global2 drawPic: 340 9)
				(= cycles (= cycles 1))
			)
			(2
				(bubbles setScript: bubbleStuff)
				(eco1 setScript: credit)
				(dolphin
					show:
					view: 362
					setLoop: 0
					setCel: 0
					posn: 319 86
				)
				(= ticks (= ticks theTicks_2))
			)
			(3
				(dolphin setLoop: 0 setCel: 1 posn: 296 88)
				(= ticks (= ticks theTicks_2))
			)
			(4
				(dolphin setLoop: 0 setCel: 2 posn: 272 95)
				(= ticks (= ticks theTicks_2))
			)
			(5
				(dolphin setLoop: 0 setCel: 3 posn: 230 104)
				(= ticks (= ticks theTicks_2))
			)
			(6
				(dolphin setLoop: 0 setCel: 4 posn: 193 97)
				(= ticks (= ticks theTicks_2))
			)
			(7
				(dolphin setLoop: 0 setCel: 0 posn: 157 87)
				(= ticks (= ticks theTicks_2))
			)
			(8
				(dolphin setLoop: 0 setCel: 1 posn: 128 89)
				(= ticks (= ticks theTicks_2))
			)
			(9
				(dolphin setLoop: 0 setCel: 2 posn: 96 95)
				(= ticks (= ticks theTicks_2))
			)
			(10
				(dolphin setLoop: 0 setCel: 3 posn: 62 100)
				(= ticks (= ticks theTicks_2))
			)
			(11
				(dolphin setLoop: 0 setCel: 4 posn: 37 92)
				(= ticks (= ticks theTicks_2))
			)
			(12
				(dolphin setLoop: 0 setCel: 0 posn: 0 86)
				(= ticks (= ticks theTicks_2))
			)
			(13
				(dolphin hide:)
				(= ticks (= ticks 180))
			)
			(14 (self dispose:))
		)
	)
)

(instance dolphinCredit2 of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(theTheExecProducer dispose:)
				(theTheKen dispose:)
				(= cycles (= cycles 1))
			)
			(1
				(dolphin
					show:
					view: 361
					setLoop: 1
					setCel: 0
					posn: 310 180
				)
				(= ticks (= ticks theTicks_2))
			)
			(2
				(dolphin setLoop: 1 setCel: 1 posn: 291 166)
				(= ticks (= ticks theTicks_2))
			)
			(3
				(dolphin setLoop: 1 setCel: 2 posn: 262 155)
				(= ticks (= ticks theTicks_2))
			)
			(4
				(dolphin setLoop: 1 setCel: 3 posn: 233 134)
				(= ticks (= ticks theTicks_2))
			)
			(5
				(dolphin setLoop: 1 setCel: 4 posn: 209 115)
				(= ticks (= ticks theTicks_2))
			)
			(6
				(dolphin setLoop: 1 setCel: 0 posn: 172 89)
				(= ticks (= ticks theTicks_2))
			)
			(7
				(dolphin setLoop: 1 setCel: 1 posn: 156 77)
				(= ticks (= ticks theTicks_2))
			)
			(8
				(dolphin setLoop: 1 setCel: 2 posn: 126 69)
				(if (== theKen jerry)
					(self setScript: credit)
				else
					(self setScript: credit2)
				)
				(= ticks (= ticks theTicks_2))
			)
			(9
				(dolphin setLoop: 1 setCel: 3 posn: 92 45)
				(= ticks (= ticks theTicks_2))
			)
			(10
				(dolphin setLoop: 1 setCel: 4 posn: 62 31)
				(= ticks (= ticks theTicks_2))
			)
			(11
				(dolphin setLoop: 1 setCel: 1 posn: 16 -1)
				(= ticks (= ticks theTicks_2))
			)
			(12
				(dolphin hide:)
				(= ticks (= ticks 180))
			)
			(13 (self dispose:))
		)
	)
)

(instance dolphinCredit3 of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(theTheExecProducer dispose:)
				(theTheKen dispose:)
				(theTheJane dispose:)
				(= cycles (= cycles 1))
			)
			(1
				(dolphin
					show:
					view: 361
					setLoop: 0
					setCel: 0
					posn: 164 189
				)
				(= ticks (= ticks theTicks_2))
			)
			(2
				(dolphin setLoop: 0 setCel: 1 posn: 164 171)
				(= ticks (= ticks theTicks_2))
			)
			(3
				(dolphin setLoop: 0 setCel: 2 posn: 165 147)
				(= ticks (= ticks theTicks_2))
			)
			(4
				(dolphin setLoop: 0 setCel: 3 posn: 164 126)
				(= ticks (= ticks theTicks_2))
			)
			(5
				(dolphin setLoop: 0 setCel: 4 posn: 164 111)
				(= ticks (= ticks theTicks_2))
			)
			(6
				(dolphin setLoop: 0 setCel: 0 posn: 164 92)
				(= ticks (= ticks theTicks_2))
			)
			(7
				(dolphin setLoop: 0 setCel: 1 posn: 164 73)
				(= ticks (= ticks theTicks_2))
			)
			(8
				(dolphin setLoop: 0 setCel: 1 posn: 163 57)
				(self setScript: credit)
				(= ticks (= ticks theTicks_2))
			)
			(9
				(dolphin setLoop: 0 setCel: 2 posn: 163 40)
				(= ticks (= ticks theTicks_2))
			)
			(10
				(dolphin setLoop: 0 setCel: 3 posn: 163 15)
				(= ticks (= ticks theTicks_2))
			)
			(11
				(dolphin setLoop: 0 setCel: 4 posn: 163 -10)
				(= ticks (= ticks theTicks_2))
			)
			(12
				(dolphin hide:)
				(= ticks (= ticks 180))
			)
			(13 (self dispose:))
		)
	)
)

(instance dolphinNoCredit of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(theTheExecProducer dispose:)
				(theTheKen dispose:)
				(global2 drawPic: 901 9)
				(= cycles (= cycles 1))
			)
			(1
				(global2 drawPic: 340 9)
				(= cycles (= cycles 1))
			)
			(2
				(bubbles setScript: bubbleStuff)
				(dolphin
					show:
					view: 361
					setLoop: 1
					setCel: 0
					posn: 310 180
				)
				(= ticks (= ticks theTicks_2))
			)
			(3
				(dolphin setLoop: 1 setCel: 1 posn: 291 166)
				(= ticks (= ticks theTicks_2))
			)
			(4
				(dolphin setLoop: 1 setCel: 2 posn: 262 155)
				(= ticks (= ticks theTicks_2))
			)
			(5
				(dolphin setLoop: 1 setCel: 3 posn: 233 134)
				(= ticks (= ticks theTicks_2))
			)
			(6
				(dolphin setLoop: 1 setCel: 4 posn: 209 115)
				(= ticks (= ticks theTicks_2))
			)
			(7
				(dolphin setLoop: 1 setCel: 0 posn: 172 89)
				(= ticks (= ticks theTicks_2))
			)
			(8
				(dolphin setLoop: 1 setCel: 1 posn: 156 77)
				(= ticks (= ticks theTicks_2))
			)
			(9
				(dolphin setLoop: 1 setCel: 2 posn: 126 69)
				(= ticks (= ticks theTicks_2))
			)
			(10
				(dolphin setLoop: 1 setCel: 3 posn: 92 45)
				(= ticks (= ticks theTicks_2))
			)
			(11
				(dolphin setLoop: 1 setCel: 4 posn: 62 31)
				(= ticks (= ticks theTicks_2))
			)
			(12
				(dolphin setLoop: 1 setCel: 1 posn: 16 -1)
				(= ticks (= ticks theTicks_2))
			)
			(13
				(dolphin hide:)
				(= cycles (= cycles 1))
			)
			(14 (self dispose:))
		)
	)
)

(instance oceanNoCredit of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(global2 drawPic: 321 9)
				(= cycles (= cycles 1))
			)
			(1
				(dolphin
					show:
					view: 361
					setLoop: 2
					setCel: 0
					posn: 157 82
					setCycle: CT 7 1 self
				)
			)
			(2
				(gSoundEffects number: 398 play:)
				(dolphin setCycle: End self)
			)
			(3
				(dolphin hide:)
				(= ticks (= ticks 120))
			)
			(4 (self dispose:))
		)
	)
)

(instance dolphinNet of Script
	(properties)
	
	(method (doit)
		(super doit: &rest)
		(cond 
			(local16 (net posn: (Random 148 149) (Random 68 69)))
			(local18 (dolphin posn: (+ (net x?) 7) (+ (net y?) 8)))
			(local17 (dolphin posn: (+ (net x?) 7) (+ (net y?) 8)))
		)
	)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(global2 drawPic: 901 9)
				(= cycles (= cycles 1))
			)
			(1
				(= theTicks_2 7)
				(= local14 1)
				(net init: setCel: 0)
				(global2 drawPic: 340 9)
				(= local6 1)
				(= cycles (= cycles 1))
			)
			(2 (= ticks (= ticks 300)))
			(3
				(= local14 0)
				(= ticks (= ticks 60))
			)
			(4
				(= local15 1)
				(dolphin
					show:
					view: 342
					setLoop: 0
					setCel: 0
					posn: 287 -10
				)
				(= ticks (= ticks theTicks_2))
			)
			(5
				(dolphin setLoop: 0 setCel: 1 posn: 245 13)
				(= ticks (= ticks theTicks_2))
			)
			(6
				(dolphin setLoop: 0 setCel: 3 posn: 225 36)
				(= ticks (= ticks theTicks_2))
			)
			(7
				(dolphin setLoop: 0 setCel: 2 posn: 191 61)
				(= ticks (= ticks theTicks_2))
			)
			(8
				(gLongSong number: 361 loop: 1 play:)
				(= local16 0)
				(dolphin
					setLoop: 1
					setCel: 1
					posn: 166 87
					setCycle: CT 5 1
				)
				(net setLoop: 0 cycleSpeed: 12 setCycle: End self)
			)
			(9
				(dolphin
					setMotion: MoveTo (- (dolphin x?) 16) (+ (dolphin y?) 8)
				)
				(net
					setMotion: MoveTo (- (net x?) 16) (+ (net y?) 8) self
				)
			)
			(10
				(= local18 1)
				(net moveSpeed: 9 setMotion: MoveTo (+ (net x?) 25) 25)
				(dolphin
					cycleSpeed: 12
					setLoop: 2
					setCel: 0
					setCycle: End self
				)
			)
			(11
				(dolphin setCycle: CT 3 -1 self)
			)
			(12
				(dolphin
					cycleSpeed: 12
					setLoop: 2
					setCel: 0
					setCycle: End self
				)
			)
			(13
				(= ticks (= ticks (Random 10 90)))
			)
			(14
				(if
				(or (>= (net y?) 27) (< (gLongSong prevSignal?) 10))
					(dolphin setCycle: CT 3 -1)
					(= state (= state (- state 3)))
				)
				(= cycles (= cycles 1))
			)
			(15
				(dolphin setCycle: End self)
			)
			(16
				(if (== (gLongSong prevSignal?) -1)
					(= cycles (= cycles 3))
				else
					(= state (= state (- state 1)))
					(= cycles (= cycles 1))
				)
			)
			(17
				(gCast eachElementDo: #hide)
				(localproc_00bc)
				(= cycles (= cycles 1))
			)
			(18 (self dispose:))
		)
	)
)

(instance credit of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(theExecProducer init: stopUpd:)
				(theKen init: stopUpd:)
				(= cycles (= cycles 1))
			)
			(1 (self dispose:))
		)
	)
)

(instance credit2 of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(theExecProducer init: stopUpd:)
				(theKen init: stopUpd:)
				(theJane init: stopUpd:)
				(= cycles (= cycles 1))
			)
			(1 (self dispose:))
		)
	)
)

(instance dolphin of EcoActor
	(properties
		view 360
		priority 14
		signal $4010
	)
)

(instance cycleStuff of PalCycle
	(properties)
	
	(method (palCycle)
		(switch local6
			(0
				(Palette palANIMATE 128 175 3)
			)
			(1
				(Palette palANIMATE 194 237 1)
			)
			(2
				(Palette palANIMATE 64 110 4)
			)
		)
	)
	
	(method (atInt param1)
		(= intLo (= intLo [theIntLo param1]))
		(= intHi (= intHi [theIntLo (+ param1 1)]))
	)
)

(instance eco1 of EcoProp
	(properties
		view 364
		priority 5
		signal $0010
		cycleSpeed 8
	)
)

(instance eco2 of EcoProp
	(properties
		view 364
		priority 5
		signal $0010
		cycleSpeed 8
	)
)

(instance bubbles of EcoActor
	(properties
		view 365
		signal $4000
	)
)

(instance presents of EcoView
	(properties
		x 64
		y 56
		view 40
		signal $4000
	)
)

(instance an of EcoView
	(properties
		x 138
		y 89
		view 40
		loop 1
		signal $4000
	)
)

(instance under of EcoView
	(properties
		x 65
		y 119
		view 40
		loop 2
		signal $4000
	)
)

(instance adven of EcoView
	(properties
		x 69
		y 144
		view 40
		loop 3
		signal $4000
	)
)

(instance execProducer of EcoView
	(properties
		x 82
		y 99
		view 956
		priority 1
		signal $4010
	)
)

(instance ken of EcoView
	(properties
		x 90
		y 116
		view 956
		cel 1
		priority 1
		signal $4010
	)
)

(instance creatDirector of EcoView
	(properties
		x 87
		y 47
		view 956
		cel 2
		priority 1
		signal $4010
	)
)

(instance billD of EcoView
	(properties
		x 107
		y 66
		view 956
		cel 3
		priority 1
		signal $4010
	)
)

(instance director of EcoView
	(properties
		x 129
		y 90
		view 956
		cel 4
		priority 1
		signal $4010
	)
)

(instance billS of EcoView
	(properties
		x 55
		y 108
		view 956
		cel 5
		priority 1
		signal $4010
	)
)

(instance producer of EcoView
	(properties
		x 128
		y 46
		view 956
		cel 6
		priority 1
		signal $4010
	)
)

(instance tammy of EcoView
	(properties
		x 77
		y 63
		view 956
		cel 7
		priority 1
		signal $4010
	)
)

(instance gameDesign of EcoView
	(properties
		x 100
		y 49
		view 956
		loop 1
		priority 1
		signal $4010
	)
)

(instance gano of EcoView
	(properties
		x 104
		y 65
		view 956
		loop 1
		cel 1
		priority 1
		signal $4010
	)
)

(instance jane of EcoView
	(properties
		x 99
		y 87
		view 956
		loop 1
		cel 2
		priority 1
		signal $4010
	)
)

(instance artDesign of EcoView
	(properties
		x 116
		y 51
		view 956
		loop 1
		cel 3
		priority 1
		signal $4010
	)
)

(instance billS2 of EcoView
	(properties
		x 59
		y 65
		view 956
		loop 1
		cel 4
		priority 1
		signal $4010
	)
)

(instance leadProgram of EcoView
	(properties
		x 92
		y 46
		view 956
		loop 1
		cel 5
		priority 1
		signal $4010
	)
)

(instance jerry of EcoView
	(properties
		x 99
		y 64
		view 956
		loop 1
		cel 6
		priority 1
		signal $4010
	)
)

(instance composer of EcoView
	(properties
		x 125
		y 99
		view 956
		loop 1
		cel 7
		priority 1
		signal $4010
	)
)

(instance chris of EcoView
	(properties
		x 80
		y 114
		view 956
		loop 1
		cel 8
		priority 1
		signal $4010
	)
)

(instance net of EcoActor
	(properties
		x 148
		y 68
		view 363
	)
)

(instance dolphinOsc of Osc
	(properties)
	
	(method (doit &tmp oscNextCel)
		(if
			(or
				(> (= oscNextCel (self nextCel:)) 5)
				(< oscNextCel 3)
			)
			(= cycleDir (= cycleDir (- cycleDir)))
			(self cycleDone:)
		else
			(client cel: oscNextCel)
		)
	)
)

(instance sfx of Sound
	(properties
		flags $0001
		number 362
	)
)
