;;; Sierra Script 1.0 - (do not remove this comment)
(script# 680)
(include sci.sh)
(use Main)
(use EcoRoom)
(use EcoFeature)
(use EcoDialog)
(use n958)
(use Sound)
(use Cycle)
(use Obj)

(public
	rm680 0
)

(local
	local0
	[local1 11] = [5 8 11 9 10 4 13 8 13 15 -1]
	local12 =  9
	local13
	local14
	local15
	local16
)
(procedure (localproc_002e param1 &tmp temp0)
	(= local14 1)
	(= local15 0)
	(= local16 param1)
)

(procedure (localproc_003d param1 &tmp temp0)
	(= temp0 100)
	(while (>= temp0 0)
		(Palette palSET_INTENSITY 33 255 temp0)
		(Wait param1)
		(= temp0 (- temp0 5))
	)
)

(procedure (localproc_0068 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
	(asm
		ldi      0
		sat      temp3
		ldi      250
		sat      temp4
		ldi      180
		sat      temp5
code_0078:
		ldi      1
		bnt      code_0123
		lat      temp3
		lali     local1
		sat      temp2
		push    
		ldi      65535
		eq?     
		bnt      code_008c
		jmp      code_0123
code_008c:
		ldi      0
		sat      temp1
code_0090:
		lat      temp2
		bnt      code_00f2
		pushi    #new
		pushi    0
		lofsa    endingCredits
		send     4
		sat      temp0
		pushi    #setLoop
		pushi    1
		lsl      local0
		pushi    156
		pushi    1
		lst      temp1
		pushi    290
		pushi    3
		class    MoveTo
		push    
		pushi    159
		pushi    65521
		pushi    110
		pushi    0
		lat      temp0
		send     26
		+at      temp1
		-at      temp2
code_00c6:
		pushi    #y
		pushi    0
		lat      temp0
		send     4
		push    
		lat      temp4
		gt?     
		bnt      code_0090
		lsg      global86
		pushi    0
		callk    GetTime,  0
		add     
		sag      gCycleCnt
		pushi    2
		pushi    #elements
		pushi    0
		lag      gCast
		send     4
		push    
		pushi    1
		callk    Animate,  4
		jmp      code_00c6
		jmp      code_0090
code_00f2:
		pushi    #y
		pushi    0
		lat      temp0
		send     4
		push    
		lat      temp5
		gt?     
		bnt      code_011c
		lsg      global86
		pushi    0
		callk    GetTime,  0
		add     
		sag      gCycleCnt
		pushi    2
		pushi    #elements
		pushi    0
		lag      gCast
		send     4
		push    
		pushi    1
		callk    Animate,  4
		jmp      code_00f2
code_011c:
		+at      temp3
		+al      local0
		jmp      code_0078
code_0123:
		ret     
	)
)

(instance rm680 of EcoRoom
	(properties
		picture 680
		style $0007
	)
	
	(method (init)
		(proc958_0 128 681 959)
		(proc958_0 132 382 385 383 917 398)
		(super init: &rest)
		(adamwave init: setCycle: Fwd)
		(sparkle init: setCycle: Fwd)
		(pierwave init: setCycle: Fwd)
		(boatwave init: setCycle: Fwd)
		(stars init: setCycle: Fwd)
		(proc0_1)
		(SetCursor 957 0 9)
		(self setScript: sEndIt)
	)
	
	(method (doit)
		(SetCursor 957 0 9)
		(SetCursor 0 200)
		(if local14
			(Palette
				palSET_INTENSITY
				0
				255
				(= local15 (+ local15 local16))
			)
			(if (>= local15 100) (= local14 0))
		)
		(super doit: &rest)
	)
)

(instance sEndIt of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 30] [temp30 30] [temp60 30] [temp90 30])
		(asm
			lap      newState
			aTop     state
			push    
			dup     
			ldi      0
			eq?     
			bnt      code_0218
			pushi    1
			pushi    1
			call     localproc_002e,  2
			ldi      300
			aTop     ticks
			jmp      code_0446
code_0218:
			dup     
			ldi      1
			eq?     
			bnt      code_022f
			lag      gTheNewEcoDialog
			bnt      code_0228
			pushi    #dispose
			pushi    0
			send     4
code_0228:
			ldi      120
			aTop     ticks
			jmp      code_0446
code_022f:
			dup     
			ldi      2
			eq?     
			bnt      code_0249
			lal      local14
			bnt      code_0242
			dpToa    state
			ldi      1
			aTop     cycles
			jmp      code_0446
code_0242:
			ldi      1
			aTop     cycles
			jmp      code_0446
code_0249:
			dup     
			ldi      3
			eq?     
			bnt      code_028b
			pushi    #number
			pushi    1
			pushi    917
			pushi    3
			pushi    1
			pushi    1
			pushi    39
			pushi    0
			lag      gSoundEffects
			send     16
			pushi    #init
			pushi    0
			pushi    155
			pushi    1
			pushi    0
			pushi    156
			pushi    1
			pushi    0
			pushi    161
			pushi    4
			class    CT
			push    
			pushi    9
			pushi    1
			pushSelf
			lofsa    dolphin
			send     28
			jmp      code_0446
code_028b:
			dup     
			ldi      4
			eq?     
			bnt      code_02b8
			pushi    #number
			pushi    1
			pushi    382
			pushi    3
			pushi    1
			pushi    1
			pushi    39
			pushi    0
			lofsa    sfx
			send     16
			pushi    #setCycle
			pushi    2
			class    End
			push    
			pushSelf
			lofsa    dolphin
			send     8
			jmp      code_0446
code_02b8:
			dup     
			ldi      5
			eq?     
			bnt      code_02e4
			pushi    #setLoop
			pushi    1
			pushi    1
			pushi    156
			pushi    1
			pushi    0
			pushi    247
			pushi    1
			pushi    12
			pushi    161
			pushi    2
			class    End
			push    
			pushSelf
			lofsa    dolphin
			send     26
			jmp      code_0446
code_02e4:
			dup     
			ldi      6
			eq?     
			bnt      code_0306
			pushi    #number
			pushi    1
			pushi    398
			pushi    3
			pushi    1
			pushi    1
			pushi    39
			pushi    0
			lag      gSoundEffects
			send     16
			ldi      30
			aTop     ticks
			jmp      code_0446
code_0306:
			dup     
			ldi      7
			eq?     
			bnt      code_0332
			pushi    #number
			pushi    1
			pushi    383
			pushi    3
			pushi    1
			pushi    65535
			pushi    39
			pushi    0
			lag      gLongSong
			send     16
			pushi    #dispose
			pushi    0
			lofsa    dolphin
			send     4
			ldi      180
			aTop     ticks
			jmp      code_0446
code_0332:
			dup     
			ldi      8
			eq?     
			bnt      code_033f
			call     localproc_0068,  0
			jmp      code_0446
code_033f:
			dup     
			ldi      9
			eq?     
			bnt      code_034c
			ldi      10
			aTop     seconds
			jmp      code_0446
code_034c:
			dup     
			ldi      10
			eq?     
			bnt      code_0446
			lag      gTheNewEcoDialog
			bnt      code_035d
			pushi    #dispose
			pushi    0
			send     4
code_035d:
			pushi    3
			pushi    957
			pushi    0
			pushi    8
			callk    SetCursor,  6
			pushi    7
			pushi    0
			pushi    0
			pushi    1
			pushi    0
			pushi    0
			pushi    35
			lea      @temp0
			push    
			callk    Message,  14
			pushi    7
			pushi    0
			pushi    0
			pushi    1
			pushi    0
			pushi    0
			pushi    36
			lea      @temp30
			push    
			callk    Message,  14
			pushi    7
			pushi    0
			pushi    0
			pushi    1
			pushi    0
			pushi    1
			pushi    1
			lea      @temp60
			push    
			callk    Message,  14
			pushi    7
			pushi    0
			pushi    0
			pushi    1
			pushi    0
			pushi    0
			pushi    7
			lea      @temp90
			push    
			callk    Message,  14
code_03bd:
			pushi    16
			lea      @temp0
			push    
			pushi    64
			pushi    65535
			pushi    40
			pushi    109
			pushi    78
			lea      @temp30
			push    
			pushi    1
			pushi    109
			pushi    78
			lea      @temp60
			push    
			pushi    2
			pushi    109
			pushi    78
			lea      @temp90
			push    
			pushi    3
			calle    proc821_3,  32
			push    
			dup     
			ldi      1
			eq?     
			bnt      code_03fe
			pushi    #restore
			pushi    0
			lag      gGame
			send     4
			jmp      code_0442
code_03fe:
			dup     
			ldi      2
			eq?     
			bnt      code_040e
			pushi    #restart
			pushi    0
			lag      gGame
			send     4
			jmp      code_0442
code_040e:
			dup     
			ldi      3
			eq?     
			bnt      code_0442
			pushi    #fade
			pushi    4
			pushi    0
			pushi    10
			pushi    4
			pushi    1
			lag      gLongSong
			send     12
			pushi    1
			pushi    8
			call     localproc_003d,  2
			pushi    1
			pushi    0
			callk    Wait,  2
			pushi    1
			pushi    300
			callk    Wait,  2
			ldi      1
			sag      global4
			jmp      code_0446
code_0442:
			toss    
			jmp      code_03bd
code_0446:
			toss    
			ret     
		)
	)
)

(instance endingCredits of EcoActor
	(properties
		x 159
		y 330
		view 959
		priority 15
		signal $6010
		illegalBits $0000
		moveSpeed 1
	)
	
	(method (doit)
		(super doit: &rest)
		(if (< y -10)
			(self dispose:)
			(if (and (== loop local12) (== cel local13))
				(sEndIt cue:)
			)
		)
	)
)

(instance dolphin of EcoProp
	(properties
		x 99
		y 79
		view 681
		signal $4000
		cycleSpeed 18
	)
)

(instance sparkle of EcoProp
	(properties
		x 42
		y 98
		view 681
		loop 2
		cel 1
		cycleSpeed 24
	)
)

(instance adamwave of EcoProp
	(properties
		x 184
		y 67
		view 681
		loop 3
	)
)

(instance pierwave of EcoProp
	(properties
		x 193
		y 173
		view 681
		loop 4
		cycleSpeed 18
	)
)

(instance boatwave of EcoProp
	(properties
		x 108
		y 189
		view 681
		loop 5
		cel 3
		cycleSpeed 18
	)
)

(instance stars of EcoProp
	(properties
		x 163
		y 26
		view 681
		loop 6
		cel 3
		cycleSpeed 24
	)
)

(instance sfx of Sound
	(properties
		flags $0001
		number 382
	)
)
